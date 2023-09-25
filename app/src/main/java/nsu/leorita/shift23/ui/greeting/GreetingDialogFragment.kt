package nsu.leorita.shift23.ui.greeting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import nsu.leorita.shift23.databinding.FragmentGreetingDialogBinding
import nsu.leorita.shift23.ui.factory

class GreetingDialogFragment : DialogFragment() {
    private val viewModel: GreetingDialogViewModel by viewModels { factory() }

    private var _binding: FragmentGreetingDialogBinding? = null
    private val binding
        get() = requireNotNull(_binding)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGreetingDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val surname = viewModel.getUserSurname()
        val name = viewModel.getUserName()
        binding.greetingText.text = "Привет, %s %s!".format(surname, name)
    }
}