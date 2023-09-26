package nsu.leorita.shift23.ui.spalsh

import androidx.lifecycle.ViewModel
import nsu.leorita.shift23.domain.PrefsRepository

class SplashViewModel(
    private val prefsRepository: PrefsRepository
) : ViewModel() {

    fun checkIsLoggedOut() = prefsRepository.getPassword()?.isEmpty() ?: true
}