package roman.bannikov.therickandmorty.viewmodels.location

import androidx.lifecycle.SavedStateHandle
import roman.bannikov.foundation.navigator.Navigator
import roman.bannikov.foundation.uiactions.UiActions
import roman.bannikov.foundation.views.BaseViewModel
import roman.bannikov.therickandmorty.views.fragments.episode.EpisodeDetailsFragment
import roman.bannikov.therickandmorty.views.fragments.location.LocationDetailsFragment


class LocationDetailsViewModel(
    //перечисляем зависимости этой вью-модели
    screen: LocationDetailsFragment.LocationDetailsScreen,
    private val navigator: Navigator,
    private val uiActions: UiActions,
//    private val episodeRepository: EpisodeRepository,
    savedStateHandle: SavedStateHandle
) : BaseViewModel(){




    fun onBtnBackPressed() {
        navigator.goBack()
    }

}
