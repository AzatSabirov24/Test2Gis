package com.example.splash.router

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.coordinator.FeatureCoordinator

class SplashRouter(
    private val coordinator: FeatureCoordinator
) {

    fun openMainActivity(activity: FragmentActivity) {
        coordinator.navigateToFeature(activity)
        activity.finish()
    }
}