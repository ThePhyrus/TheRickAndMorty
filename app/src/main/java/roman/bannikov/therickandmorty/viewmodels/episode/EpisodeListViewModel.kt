package roman.bannikov.therickandmorty.viewmodels.episode

import roman.bannikov.foundation.navigator.Navigator
import roman.bannikov.foundation.uiactions.UiActions
import roman.bannikov.foundation.views.BaseViewModel
import roman.bannikov.therickandmorty.views.fragments.character.CharacterDetailsFragment


class EpisodeListViewModel(
    private val navigator: Navigator,
    private val uiActions: UiActions,
//    private val episodeRepository: EpisodeRepository
) : BaseViewModel() {

    fun onFilterPressed () {
        //todo launch episode filter fragment
    }

    fun onDetailsPressed(){
//        navigator.launch(EpisodeDetailsFragment.EpisodeDetailsScreen(100L)) //fixme передать выброанний эпизод
    }

}