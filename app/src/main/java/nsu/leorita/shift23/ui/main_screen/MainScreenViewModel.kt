package nsu.leorita.shift23.ui.main_screen

import androidx.lifecycle.ViewModel
import nsu.leorita.shift23.domain.PrefsRepository

class MainScreenViewModel(
    private val prefsRepository: PrefsRepository
) : ViewModel() {

    fun logOut() {
        prefsRepository.logout()
    }
}