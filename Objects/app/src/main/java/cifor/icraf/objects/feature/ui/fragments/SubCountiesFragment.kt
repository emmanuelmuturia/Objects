package cifor.icraf.objects.feature.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cifor.icraf.objects.R
import cifor.icraf.objects.databinding.FragmentSubCountiesBinding

class SubCountiesFragment : Fragment() {

    private var _binding: FragmentSubCountiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubCountiesBinding.inflate(
            inflater,
            container,
            false
        )
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