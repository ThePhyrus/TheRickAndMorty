package roman.bannikov.therickandmorty.views.fragments.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import roman.bannikov.foundation.views.BaseFragment
import roman.bannikov.foundation.views.BaseScreen
import roman.bannikov.foundation.views.screenViewModel
import roman.bannikov.therickandmorty.databinding.FragmentCharacterListBinding
import roman.bannikov.therickandmorty.viewmodels.character.CharacterListViewModel

class CharacterListFragment : BaseFragment() {

    // no arguments for this screen
    class CharacterListScreen : BaseScreen

    override val viewModel by screenViewModel<CharacterListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentCharacterListBinding.inflate(inflater, container, false)


        //todo переделать клик на карточку персонажа
        binding.btnShowDetails.setOnClickListener { viewModel.onDetailsPressed() }


        return binding.root
    }


}