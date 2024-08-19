package cifor.icraf.objects.feature.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import cifor.icraf.objects.R
import cifor.icraf.objects.databinding.FragmentSubCountiesBinding
import cifor.icraf.objects.feature.data.models.County
import cifor.icraf.objects.feature.ui.viewmodel.ObjectsViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.ext.android.viewModel

class SubCountiesFragment : Fragment() {

    private var _binding: FragmentSubCountiesBinding? = null
    private val binding get() = _binding!!

    private val objectsViewModel by viewModel<ObjectsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSubCountiesBinding.inflate(
            inflater,
            container,
            false
        )

        val countyId = SubCountiesFragmentArgs.fromBundle(bundle = requireArguments()).countryId
        objectsViewModel.getSubCountiesById(countyId = countyId)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                objectsViewModel.county.collect { county ->
                    if (county != null) {
                        val subCountiesFragmentSpinner = binding.subCountiesFragmentSpinner
                        subCountiesFragmentSpinner.adapter =
                                ArrayAdapter(
                                    requireContext(),
                                    android.R.layout.simple_spinner_dropdown_item,
                                    county.countySubCounties
                                )
                    }
                }
            }
        }

        binding.subCountiesFragmentToolBar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}