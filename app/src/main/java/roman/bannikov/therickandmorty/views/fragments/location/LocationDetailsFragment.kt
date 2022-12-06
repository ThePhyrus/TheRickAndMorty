package roman.bannikov.therickandmorty.views.fragments.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import roman.bannikov.foundation.views.BaseFragment
import roman.bannikov.foundation.views.BaseScreen
import roman.bannikov.foundation.views.screenViewModel
import roman.bannikov.therickandmorty.databinding.FragmentEpisodeDetailsBinding
import roman.bannikov.therickandmorty.databinding.FragmentLocationDetailsBinding
import roman.bannikov.therickandmorty.viewmodels.location.LocationDetailsViewModel


class LocationDetailsFragment: BaseFragment() {


    class LocationDetailsScreen(

    ) : BaseScreen

    override val viewModel by screenViewModel<LocationDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLocationDetailsBinding.inflate(inflater, container, false)



        binding.btnBack.setOnClickListener { viewModel.onBtnBackPressed() }





        return binding.root
    }
}
