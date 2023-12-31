package nsu.leorita.shift23.ui.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import nsu.leorita.shift23.R
import nsu.leorita.shift23.databinding.FragmentMainScreenBinding
import nsu.leorita.shift23.ui.factory

class MainScreenFragment : Fragment() {

    private val viewModel: MainScreenViewModel by viewModels { factory() }

    private var _binding: FragmentMainScreenBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.greetingButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_greetingDialogFragment)
        }
        binding.logoutButton.setOnClickListener {
            viewModel.logOut()
            findNavController().setGraph(R.navigation.start_nav_graph)
        }
    }
}