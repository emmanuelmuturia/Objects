package cifor.icraf.objects.feature.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cifor.icraf.objects.R
import cifor.icraf.objects.databinding.FragmentCountiesBinding

class CountiesFragment : Fragment() {

    private var _binding: FragmentCountiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountiesBinding.inflate(
            inflater,
            container,
            false
        )
        binding.homeFragmentNextButton.setOnClickListener {
            val action = CountiesFragmentDirections.actionCountiesFragmentToSubCountiesFragment()
            findNavController().navigate(action)
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