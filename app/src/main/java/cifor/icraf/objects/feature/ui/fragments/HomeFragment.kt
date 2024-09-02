package cifor.icraf.objects.feature.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import cifor.icraf.objects.databinding.FragmentHomeBinding
import cifor.icraf.objects.feature.ui.viewmodel.ObjectsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val objectsViewModel by viewModel<ObjectsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )

        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(binding.homeFragmentToolBar)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            objectsViewModel.objectsUIState.collect { uiState ->

                val homeFragmentSpinner = binding.homeFragmentSpinner
                homeFragmentSpinner.adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_dropdown_item,
                    uiState.objects.map { it.countryName }
                )

                binding.homeFragmentNextButton.setOnClickListener {
                    val actions = HomeFragmentDirections.actionHomeFragmentToCountiesFragment(
                        countryName = homeFragmentSpinner.selectedItem.toString()
                    )
                    findNavController().navigate(actions)
                }

            }
        }

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}