package cifor.icraf.objects.feature.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import cifor.icraf.objects.databinding.FragmentHomeBinding
import cifor.icraf.objects.feature.ui.adapter.HomeFragmentAdapter
import cifor.icraf.objects.feature.ui.viewmodel.ObjectsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

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

        val homeFragmentAdapter = HomeFragmentAdapter()

        binding.objectList.adapter = homeFragmentAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            objectsViewModel.objectsUIState.collect { objectsUIState ->
                Timber.tag("HomeFragment").d(message = "UIState: $objectsUIState") // Debug line

                homeFragmentAdapter.submitList(objectsUIState.objects)

                binding.homeFragmentCircularProgressBar.visibility =
                    if (objectsUIState.isLoading) View.VISIBLE else View.GONE

                binding.objectList.visibility =
                    if (objectsUIState.isLoading) View.GONE else View.VISIBLE

                binding.homeFragmentErrorMessage.visibility =
                    if (objectsUIState.error != null) View.VISIBLE else View.GONE

                binding.homeFragmentErrorMessageValue.text = objectsUIState.error

                binding.homeFragmentErrorMessageValue.visibility =
                    if (objectsUIState.error != null) View.VISIBLE else View.GONE
            }
        }

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}