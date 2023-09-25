package nsu.leorita.shift23.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nsu.leorita.shift23.App
import nsu.leorita.shift23.ui.greeting.GreetingDialogViewModel
import nsu.leorita.shift23.ui.registration.RegistrationViewModel

class ViewModelFactory (
    private val app: App
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when (modelClass) {
            RegistrationViewModel::class.java -> {
                 RegistrationViewModel(app.prefs)
            }
            GreetingDialogViewModel::class.java -> {
                GreetingDialogViewModel(app.prefs)
            }
            else -> {
                throw IllegalStateException("Unknown view model class")
            }
        }
        return viewModel as T
    }
}

fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App)