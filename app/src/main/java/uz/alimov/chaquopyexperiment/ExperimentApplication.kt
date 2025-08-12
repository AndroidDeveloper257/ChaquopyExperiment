package uz.alimov.chaquopyexperiment

import android.app.Application
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class ExperimentApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Python.start(AndroidPlatform(this))
    }
}