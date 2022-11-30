package roman.bannikov.therickandmorty

import android.app.Application
import roman.bannikov.foundation.BaseApplication
import roman.bannikov.foundation.model.Repository
import roman.bannikov.therickandmorty.model.colors.InMemoryColorsRepository

/**
 * Точка входа в приложение (прописывается в манифесте). Этот класс являестся "singletone scope",
 * который содежить модели. В данном случае здесь только дин репозиторий, который отвечает за \
 * хранение и выбор цвета. Репозитории можно добавлять просто через запятую. Описание самих классов
 * модели хранится в отдекльном пакете (model) самого приложения (не в пакете foundation).
 * */


/**
 * Here we store instances of model layer classes.
 */
class App : Application(), BaseApplication {

    /**
     * Place your repositories here, now we have only 1 repository
     */
    override val repositories: List<Repository> = listOf<Repository>(
        InMemoryColorsRepository() //Можно добавить ещё репозитории через запятую
    )

}