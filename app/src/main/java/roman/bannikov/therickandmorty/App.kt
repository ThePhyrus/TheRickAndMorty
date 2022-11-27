package roman.bannikov.therickandmorty

import android.app.Application
import roman.bannikov.foundation.BaseApplication
import roman.bannikov.foundation.model.Repository
import roman.bannikov.therickandmorty.model.colors.InMemoryColorsRepository

/**
 * Here we store instances of model layer classes.
 */
class App : Application(), BaseApplication {

    /**
     * Place your repositories here, now we have only 1 repository
     */
    override val repositories: List<Repository> = listOf<Repository>(
        InMemoryColorsRepository()
    )

}