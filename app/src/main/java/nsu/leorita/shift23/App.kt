package nsu.leorita.shift23

import android.app.Application
import nsu.leorita.shift23.domain.PrefsRepository

class App : Application() {
    private var _prefs: PrefsRepository? = null
    val prefs
        get() = requireNotNull(_prefs)

    override fun onCreate() {
        super.onCreate()
        _prefs = PrefsRepository(this)
    }
}