package com.example.coordinator

import android.content.Context

interface FeatureCoordinator {

    fun navigateToFeature(
        context: Context,
        requestKey: String? = null,
        message: Any? = null
    )
}