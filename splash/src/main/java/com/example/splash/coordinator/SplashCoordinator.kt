package com.example.splash.coordinator

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.coordinator.FeatureCoordinator
import com.example.splash.activity.SplashActivity

class SplashCoordinator : FeatureCoordinator {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun navigateToFeature(context: Context, requestKey: String?, message: Any?) {
        context.startActivity(Intent(context, SplashActivity::class.java))
    }
}