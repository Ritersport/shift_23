package nsu.leorita.shift23.ui.registration

import androidx.lifecycle.ViewModel
import nsu.leorita.shift23.domain.PrefsRepository

class RegistrationViewModel(
    private val sharedPrefsRepository: PrefsRepository,
) : ViewModel() {



    fun validate(surname: String, name: String, password: String, repeatedPassword: String) = kotlin.runCatching {
        require(surname.length >= 2 ) { ERR_SURNAME_LEN }
        require(surname.none { !it.isLetter()}) { ERR_SURNAME_LETTER }

        require(name.length >= 2 ) { ERR_NAME_LEN }
        require(name.none { !it.isLetter()}) { ERR_NAME_LETTER }

        require(password.length >= 8) { ERR_PASS_LEN }
        require(password.none { it.isWhitespace() }) { ERR_PASS_WHITESPACE }
        require(password.any { it.isDigit() }) { ERR_PASS_DIGIT }
        require(password.any { it.isUpperCase() }) { ERR_PASS_UPPER }
        require(password.any { !it.isLetterOrDigit() }) { ERR_PASS_SPECIAL }

        require(password == repeatedPassword) { ERR_PASS_DIF }

    }

    fun saveData(surname: String, name: String, birthdate: String, password: String) {
        with(sharedPrefsRepository) {
            setSurname(surname)
            setName(name)
            setBirthdate(birthdate)
            setPassword(password)
        }
    }


    companion object RegistrationErrors {
        const val ERR_PASS_LEN = "Password must have at least eight characters"
        const val ERR_PASS_WHITESPACE = "Password must not contain whitespace"
        const val ERR_PASS_DIGIT = "Password must contain at least one digit"
        const val ERR_PASS_UPPER = "Password must have at least one uppercase letter"
        const val ERR_PASS_SPECIAL = "Password must have at least one special character, such as: _%-=+#@"
        const val ERR_SURNAME_LEN = "Surname must have at least two characters"
        const val ERR_SURNAME_LETTER = "Surname must contain letters only"
        const val ERR_NAME_LEN = "Name must have at least two characters"
        const val ERR_NAME_LETTER = "Name must contain letters only"
        const val ERR_PASS_DIF = "Passwords must be equal"
    }
}