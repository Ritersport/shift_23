package nsu.leorita.shift23.ui.greeting

import androidx.lifecycle.ViewModel
import nsu.leorita.shift23.domain.PrefsRepository

class GreetingDialogViewModel(
    private val prefsRepository: PrefsRepository
) : ViewModel() {

    fun getUserSurname() = prefsRepository.getSurname()

    fun getUserName() = prefsRepository.getName()
}