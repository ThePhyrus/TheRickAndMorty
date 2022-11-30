package roman.bannikov.foundation.navigator

import android.os.Bundle
import android.view.View
import androidx.annotation.AnimRes
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import roman.bannikov.foundation.utils.Event
import roman.bannikov.foundation.views.BaseFragment
import roman.bannikov.foundation.views.BaseScreen
import roman.bannikov.foundation.views.BaseScreen.Companion.ARG_SCREEN
import roman.bannikov.foundation.views.HasScreenTitle

class StackFragmentNavigator(
    private val activity: AppCompatActivity,
    @IdRes private val containerId: Int,
    private val defaultTitle: String,
    private val animations: Animations,
    private val initialScreenCreator: () -> BaseScreen
) : Navigator {

    private var result: Event<Any>? = null

    override fun launch(screen: BaseScreen) {
        launchFragment(screen)//если второй аргумент не передать, что добавится в бэкстек
    }

    override fun goBack(result: Any?) {
        /**
         * Для передачи результатов обратно в предыдущий экран.
         * Когда вызывается этот метод, мы (какач-то вью-модель) можем (может) передать сюда
         * результат. Например, так работает ChangeColorViewModel при вызове метода onSavePressed().
         * */
        if (result != null) {
            this.result = Event(result)
        }
        activity.onBackPressed()
    }

    fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            // define the initial screen that should be launched when app starts.
            launchFragment(
                screen = initialScreenCreator(),
                addToBackStack = false
            )
        }
        activity.supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentCallbacks, false)
    }

    fun onDestroy() {
        activity.supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentCallbacks)
    }

    fun notifyScreenUpdates() {
        val f = activity.supportFragmentManager.findFragmentById(containerId)

        if (activity.supportFragmentManager.backStackEntryCount > 0) {
            // more than 1 screen -> show back button in the toolbar
            activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        } else {
            activity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }

        if (f is HasScreenTitle && f.getScreenTitle() != null) {
            // fragment has custom screen title -> display it
            activity.supportActionBar?.title = f.getScreenTitle()
        } else {
            activity.supportActionBar?.title = defaultTitle
        }
    }

    /**
     * Метод для запуска фрагментов.
     * Принимает два параметра (по умолчанию добавляет фрагменты в бэкстек:
     * (addToBackStack: Boolean = true)).
     *
     * */
    private fun launchFragment(screen: BaseScreen, addToBackStack: Boolean = true) {
        /**
         * Следущая строка создаёт фрагмент из объекта типа скрин. Объекты этого типа (параметр
         * screen: BaseScreen) реализуют интефейс Serializable, а это значит, что они
         * могут быть аргументами экрана. Именно поэтому их можно сложить в bundle и потом передать
         * фрагменту в качестве аргументов. Такой подход позволяет избавиться от ручного
         * опроделения метода newInstance(). Классы скринов определяются в самих фрагментах.
         * Вью-модели будут работать только со скринами, поэтому не будут зависеть от фрагментов.
         * */

        /**
         * Можно сделать вывод, что для того, чтобы передать какие-то аргументы дальше в новый
         * экран, нам нужно просто создать скрин, внутри которого описать все необходимые аргументы.
         * */
        val fragment = screen.javaClass.enclosingClass.newInstance() as Fragment
        // set screen object as fragment's argument
        fragment.arguments = bundleOf(ARG_SCREEN to screen)

        // Создаём транзакцию:
        val transaction = activity.supportFragmentManager.beginTransaction()
        // Если addToBackStack = true, то добавляем в бэкстек:
        if (addToBackStack) transaction.addToBackStack(null)
        // Добавляем анимацию (опционально)
        transaction
            .setCustomAnimations(
                animations.enterAnim,
                animations.exitAnim,
                animations.popEnterAnim,
                animations.popExitAnim,
            )
            .replace(containerId, fragment)
            .commit()
    }

    private fun publishResults(fragment: Fragment) {
        val result = result?.getValue() ?: return
        if (fragment is BaseFragment) {
            // has result that can be delivered to the screen's view-model
            fragment.viewModel.onResult(result)
        }
    }

    private val fragmentCallbacks = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
            notifyScreenUpdates()
            publishResults(f)
        }
    }

    class Animations(
        @AnimRes val enterAnim: Int,
        @AnimRes val exitAnim: Int,
        @AnimRes val popEnterAnim: Int,
        @AnimRes val popExitAnim: Int,
    )
}