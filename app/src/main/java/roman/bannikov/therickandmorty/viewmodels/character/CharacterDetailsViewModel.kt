package roman.bannikov.therickandmorty.viewmodels.character

import androidx.lifecycle.SavedStateHandle
import roman.bannikov.foundation.navigator.Navigator
import roman.bannikov.foundation.uiactions.UiActions
import roman.bannikov.foundation.views.BaseViewModel
import roman.bannikov.therickandmorty.views.fragments.character.CharacterDetailsFragment

class CharacterDetailsViewModel(
    //перечисляем зависимости этой вью-модели
    screen: CharacterDetailsFragment.CharacterDetailsScreen,
    private val navigator: Navigator,
    private val uiActions: UiActions,
//    private val colorsRepository: ColorsRepository,
    savedStateHandle: SavedStateHandle
) : BaseViewModel(){




    fun onBtnBackPressed() {
        navigator.goBack()
    }

}

