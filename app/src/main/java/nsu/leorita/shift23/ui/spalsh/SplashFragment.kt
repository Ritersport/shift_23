package nsu.leorita.shift23.ui.spalsh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import nsu.leorita.shift23.R
import nsu.leorita.shift23.databinding.FragmentSplashBinding
import nsu.leorita.shift23.ui.factory

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    private val viewModel: SplashViewModel by viewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(viewModel.checkIsLoggedOut()) {
            findNavController().navigate(R.id.action_splashFragment2_to_registrationFragment2)
        }
        else {
            findNavController().navigate(R.id.toMainScreen)
        }
    }


}