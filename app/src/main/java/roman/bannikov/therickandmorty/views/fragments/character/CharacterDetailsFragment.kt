package roman.bannikov.therickandmorty.views.fragments.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import roman.bannikov.foundation.views.BaseFragment
import roman.bannikov.foundation.views.BaseScreen
import roman.bannikov.foundation.views.screenViewModel
import roman.bannikov.therickandmorty.databinding.FragmentCharacterDetailsBinding
import roman.bannikov.therickandmorty.viewmodels.character.CharacterDetailsViewModel
import roman.bannikov.therickandmorty.viewmodels.character.CharacterListViewModel

class CharacterDetailsFragment : BaseFragment() {

    class CharacterDetailsScreen(
        val selectedCharacter: Long
    ) : BaseScreen

    override val viewModel by screenViewModel<CharacterDetailsViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)



        binding.btnBack.setOnClickListener { viewModel.onBtnBackPressed() }





        return binding.root
    }

}