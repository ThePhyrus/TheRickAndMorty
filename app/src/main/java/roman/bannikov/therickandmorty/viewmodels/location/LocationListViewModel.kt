package roman.bannikov.therickandmorty.viewmodels.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import roman.bannikov.foundation.navigator.Navigator
import roman.bannikov.foundation.uiactions.UiActions
import roman.bannikov.foundation.views.BaseViewModel
import roman.bannikov.therickandmorty.R
import roman.bannikov.therickandmorty.views.fragments.character.CharacterDetailsFragment
import roman.bannikov.therickandmorty.views.fragments.location.LocationDetailsFragment


class LocationListViewModel(
    private val navigator: Navigator,
    private val uiActions: UiActions,
//    private val locationRepository: LocationRepository
) : BaseViewModel() {

    fun onFilterPressed () {
        //todo launch location filter fragment
    }

    fun onDetailsPressed(){
      navigator.launch(LocationDetailsFragment.LocationDetailsScreen()) //fixme передать выброанную локацию
    }

}