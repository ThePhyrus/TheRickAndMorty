package roman.bannikov.therickandmorty.viewmodels.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import roman.bannikov.foundation.navigator.Navigator
import roman.bannikov.foundation.uiactions.UiActions
import roman.bannikov.foundation.views.BaseViewModel
import roman.bannikov.therickandmorty.R
import roman.bannikov.therickandmorty.views.fragments.character.CharacterDetailsFragment


class CharacterListViewModel(
    private val navigator: Navigator,
    private val uiActions: UiActions,
//    private val colorsRepository: ColorsRepository
) : BaseViewModel() {

    fun onFilterPressed () {
        //todo launch character filter fragment
    }

    fun onDetailsPressed(){
      navigator.launch(CharacterDetailsFragment.CharacterDetailsScreen(100L), true) //fixme передать выброанний персонаж
    }

}