package roman.bannikov.therickandmorty.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import roman.bannikov.foundation.views.BaseFragment
import roman.bannikov.foundation.views.BaseScreen
import roman.bannikov.foundation.views.screenViewModel
import roman.bannikov.therickandmorty.databinding.FragmentCharacterListBinding
import roman.bannikov.therickandmorty.databinding.FragmentLocationListBinding
import roman.bannikov.therickandmorty.viewmodels.character.CharacterListViewModel
import roman.bannikov.therickandmorty.viewmodels.location.LocationListViewModel

class LocationListFragment:BaseFragment (){



    // no arguments for this screen
    class LocationListScreen : BaseScreen

    override val viewModel by screenViewModel<LocationListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentLocationListBinding.inflate(inflater, container, false)


        //todo переделать клик на карточку локации
        binding.btnShowDetails.setOnClickListener { viewModel.onDetailsPressed() }


        return binding.root
    }

}