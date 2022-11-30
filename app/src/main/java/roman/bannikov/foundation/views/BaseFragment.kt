package roman.bannikov.foundation.views

import androidx.fragment.app.Fragment

/**
 * Base class for all fragments
 */
abstract class BaseFragment : Fragment() {

    /**
     * abstract class BaseFragment мы будем использовать для того, чтобы реализовывать все наши
     * экраны. Все фрагменты будут от него наследоваться.
     * */

    /**
     * View-model that manages this fragment
     * Это поле будет определять вью-модель, которая будет упровлять фрагментом
     */
    abstract val viewModel: BaseViewModel

    /**
     * Call this method when activity controls (e.g. toolbar) should be re-rendered
     */
    fun notifyScreenUpdates() {
        /**
         * Так как у нас single-activity приложение, то можно просто сделать так:
         * */
        (requireActivity() as FragmentsHolder).notifyScreenUpdates()

        /**
         * В идеале должен быть создан отдельный интерфейс и на нём должен был бы
         * вызываться notifyScreenUpdates().
         *
         * Но из-зи того, что у нас ТОЛЬКО одна активити и фрагмент может находиться
         * ТОЛЬКО в MainActivity, то в таком методе никогда и никакой ошибки не случится.
         * */
    }
}