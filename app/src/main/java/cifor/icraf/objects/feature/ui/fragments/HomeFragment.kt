package cifor.icraf.objects.feature.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import cifor.icraf.objects.databinding.FragmentCountriesBinding
import cifor.icraf.objects.feature.ui.viewmodel.ObjectsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!

    private val objectsViewModel by viewModel<ObjectsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountriesBinding.inflate(inflater, container, false)

        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(binding.homeFragmentToolBar)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                // Collect and populate the countries spinner
                launch {
                    objectsViewModel.objectsUIState.collect { uiState ->
                        val countryNames = uiState.objects.map { it.countryName }
                        val homeFragmentSpinner = binding.homeFragmentSpinner
                        homeFragmentSpinner.adapter = ArrayAdapter(
                            requireContext(),
                            android.R.layout.simple_spinner_dropdown_item,
                            countryNames
                        )

                        // Set listener to respond to country selection
                        homeFragmentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                                // Trigger fetching counties when a country is selected
                                val selectedCountry = countryNames[position]
                                objectsViewModel.getCountryByName(selectedCountry)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>) {
                                // Handle the case where no country is selected (optional)
                            }
                        }
                    }
                }

                // Collect and populate the counties spinner based on selected country
                launch {
                    objectsViewModel.country.collect { country ->
                        country?.let {
                            val countyNames = country.countryCounties.map { it.countyName }
                            val countiesFragmentSpinner = binding.countiesFragmentSpinner
                            countiesFragmentSpinner.adapter = ArrayAdapter(
                                requireContext(),
                                android.R.layout.simple_spinner_dropdown_item,
                                countyNames
                            )

                            // Set listener to respond to county selection
                            countiesFragmentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                                    // Trigger fetching sub-counties when a county is selected
                                    val selectedCounty = countyNames[position]
                                    objectsViewModel.getCountyByName(selectedCounty)
                                }

                                override fun onNothingSelected(parent: AdapterView<*>) {
                                    // Handle the case where no county is selected (optional)
                                }
                            }
                        }
                    }
                }

                // Collect and populate the sub-counties spinner based on selected county
                launch {
                    objectsViewModel.county.collect { county ->
                        county?.let {
                            val subCountyNames = county.countySubCounties.map { it.subCountyName }
                            val subCountiesFragmentSpinner = binding.subCountiesFragmentSpinner
                            subCountiesFragmentSpinner.adapter = ArrayAdapter(
                                requireContext(),
                                android.R.layout.simple_spinner_dropdown_item,
                                subCountyNames
                            )
                        }
                    }
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