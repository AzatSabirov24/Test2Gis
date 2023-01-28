package com.example.main.presentation.coordinator

import android.content.Context
import android.content.Intent
import com.example.coordinator.FeatureCoordinator
import com.example.main.presentation.activity.MainActivity

class MainCoordinator : FeatureCoordinator {

    override fun navigateToFeature(context: Context, requestKey: String?, message: Any?) {
        context.startActivity(Intent(context, MainActivity::class.java))
    }
}