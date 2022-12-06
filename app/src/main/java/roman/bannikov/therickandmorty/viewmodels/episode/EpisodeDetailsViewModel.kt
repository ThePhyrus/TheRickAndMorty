package roman.bannikov.therickandmorty.viewmodels.episode

import androidx.lifecycle.SavedStateHandle
import roman.bannikov.foundation.navigator.Navigator
import roman.bannikov.foundation.uiactions.UiActions
import roman.bannikov.foundation.views.BaseViewModel
import roman.bannikov.therickandmorty.views.fragments.character.CharacterDetailsFragment
import roman.bannikov.therickandmorty.views.fragments.episode.EpisodeDetailsFragment


class EpisodeDetailsViewModel(
    //перечисляем зависимости этой вью-модели
    screen: EpisodeDetailsFragment.EpisodeDetailsScreen,
    private val navigator: Navigator,
    private val uiActions: UiActions,
//    private val episodeRepository: EpisodeRepository,
    savedStateHandle: SavedStateHandle
) : BaseViewModel(){




    fun onBtnBackPressed() {
        navigator.goBack()
    }

}

