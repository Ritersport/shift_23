package nsu.leorita.shift23.ui.registration

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import nsu.leorita.shift23.R
import nsu.leorita.shift23.databinding.FragmentRegistrationBinding
import nsu.leorita.shift23.ui.factory
import java.time.LocalDate
import java.time.Month
import java.util.Date

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    private val viewModel: RegistrationViewModel by viewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.birthdatePicker.maxDate = Date().time

        binding.registrationButton.setOnClickListener {
            val dataValidation = viewModel.validate(
                binding.surname.text.toString(),
                binding.name.text.toString(),
                binding.pas.text.toString(),
                binding.repeatPas.text.toString(),
            )
            dataValidation.onSuccess {
                viewModel.saveData(binding.surname.text.toString(), binding.name.text.toString(), binding.birthdatePicker.toLocalDate().toString(), binding.pas.text.toString())
                findNavController().navigate(R.id.action_registrationFragment2_to_nav_graph)
            }
            dataValidation.onFailure {
                exception ->
                run {
                    binding.errorText.text = exception.message
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)

    fun DatePicker.toLocalDate() = LocalDate.of(this.year, Month.of(this.month), this.dayOfMonth)

}

