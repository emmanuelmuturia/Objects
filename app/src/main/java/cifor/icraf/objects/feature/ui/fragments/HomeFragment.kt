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
import kotlinx.coroutines.cancelChildren
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

        val homeFragmentAdapter = HomeFragmentAdapter(
            onCardClicked = {
                // Navigate to Details Fragment...
            },
            onSubmitObjectButtonClicked = {
                // POST...
            }
        )

        binding.objectList.adapter = homeFragmentAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            objectsViewModel.objectsUIState.collect { objectsUIState ->
                homeFragmentAdapter.submitList(objectsUIState.objects)
            }
        }

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        binding.objectList.adapter = null
        viewLifecycleOwner.lifecycleScope.coroutineContext.cancelChildren()
    }

}