package com.iven.vectorify

import android.app.Application
import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import com.iven.vectorify.preferences.TempPreferences
import com.iven.vectorify.preferences.VectorifyPreferences

val mVectorifyPreferences: VectorifyPreferences by lazy {
    VectorifyApp.prefs
}

val mTempPreferences: TempPreferences by lazy {
    VectorifyApp.tempPrefs
}

val mDeviceMetrics: Pair<Int, Int> by lazy {
    VectorifyApp.metrics
}

class VectorifyApp : Application() {
    companion object {
        lateinit var prefs: VectorifyPreferences
        lateinit var tempPrefs: TempPreferences
        lateinit var metrics: Pair<Int, Int>
    }

    override fun onCreate() {

        prefs = VectorifyPreferences(applicationContext)
        tempPrefs = TempPreferences()

        //retrieve display specifications
        val window = applicationContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val d = DisplayMetrics()
        window.defaultDisplay.getRealMetrics(d)
        metrics = Pair(d.widthPixels, d.heightPixels)

        super.onCreate()
    }
}
