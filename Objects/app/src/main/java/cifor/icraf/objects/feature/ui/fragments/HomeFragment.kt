package cifor.icraf.objects.feature.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import cifor.icraf.objects.databinding.FragmentHomeBinding
import cifor.icraf.objects.feature.data.models.Object
import cifor.icraf.objects.feature.ui.adapter.HomeFragmentAdapter
import cifor.icraf.objects.feature.ui.viewmodel.ObjectsViewModel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.collect
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

        val homeFragmentAdapter = HomeFragmentAdapter(
            onSubmitObjectButtonClicked = { objectId, objectName ->
                viewLifecycleOwner.lifecycleScope.launch {
                    objectsViewModel.postObject(
                        myObject = Object(
                            objectId = objectId,
                            objectName = objectName
                        )
                    )
                }
            }
        )

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

                objectsUIState.responseObject?.let { responseObject ->
                    val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
                    builder.setTitle("Object response")
                        .setMessage(
                            """
                    Object ID: ${responseObject.objectId}
                    Object Name: ${responseObject.objectName}
                    Object Creation Time: ${responseObject.objectCreatedAt}
                    """.trimIndent()
                        )
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                    Toast.makeText(
                        context,
                        "You have posted: ${responseObject.objectName}",
                        Toast.LENGTH_LONG
                    ).show()
                }
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