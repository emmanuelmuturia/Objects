package cifor.icraf.objects.feature.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import cifor.icraf.objects.R
import cifor.icraf.objects.databinding.FragmentCountiesBinding
import cifor.icraf.objects.feature.ui.viewmodel.ObjectsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountiesFragment : Fragment() {

    private var _binding: FragmentCountiesBinding? = null
    private val binding get() = _binding!!

    private val objectsViewModel by viewModel<ObjectsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountiesBinding.inflate(
            inflater,
            container,
            false
        )

        viewLifecycleOwner.lifecycleScope.launch {
            val countryId = CountiesFragmentArgs.fromBundle(bundle = requireArguments()).countryId
            val countiesFragmentSpinner = binding.countiesFragmentSpinner
            countiesFragmentSpinner.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                objectsViewModel.getCountiesById(countryId = countryId)
            )

            binding.homeFragmentNextButton.setOnClickListener {
                val action = CountiesFragmentDirections.actionCountiesFragmentToSubCountiesFragment(
                    countyId = countryId
                )
                findNavController().navigate(action)
            }
        }

        binding.countiesFragmentToolBar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}