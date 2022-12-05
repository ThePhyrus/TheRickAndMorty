package roman.bannikov.therickandmorty.views.fragments.episode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import roman.bannikov.foundation.views.BaseFragment
import roman.bannikov.foundation.views.BaseScreen
import roman.bannikov.foundation.views.screenViewModel
import roman.bannikov.therickandmorty.databinding.FragmentCharacterListBinding
import roman.bannikov.therickandmorty.databinding.FragmentEpisodeListBinding
import roman.bannikov.therickandmorty.viewmodels.character.CharacterListViewModel
import roman.bannikov.therickandmorty.viewmodels.episode.EpisodeListViewModel


class EpisodeListFragment : BaseFragment() {

    // no arguments for this screen
    class EpisodeListScreen : BaseScreen

    override val viewModel by screenViewModel<EpisodeListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentEpisodeListBinding.inflate(inflater, container, false)


        binding.btnShowEpisodeDetails.setOnClickListener { viewModel.onDetailsPressed() }



        return binding.root
    }


}