package nsu.leorita.shift23.domain

import android.content.Context
import android.content.SharedPreferences

class PrefsRepository(context: Context) {
    private val sharedPref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    private val editor = sharedPref.edit()

    fun setSurname(surname: String) {
        PREF_SURNAME.put(surname)
    }

    fun setName(name: String) {
        PREF_NAME.put(name)
    }

    fun setBirthdate(birthdate: String) {
        PREF_BIRTHDATE.put(birthdate)
    }

    fun setPassword(password: String) {
        PREF_PASSWORD.put(password)
    }

    fun getSurname() = PREF_SURNAME.getString()

    fun getName() = PREF_NAME.getString()

    fun getBirthdate() = PREF_BIRTHDATE.getString()

    fun getPassword() = PREF_PASSWORD.getString()

    fun logout()  {
        PREF_SURNAME.put("")
        PREF_NAME.put("")
        PREF_BIRTHDATE.put("")
        PREF_PASSWORD.put("")
    }


    private fun String.put(string: String) {
        editor.putString(this, string)
        editor.apply()
    }

    private fun String.getString() = sharedPref.getString(this, "")

}