package com.example.coordinator

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity

interface FeatureCoordinatorToFragment {

    fun navigateToFeature(
        activity: FragmentActivity,
        fragmentContainerId: Int,
        requestKey: String? = null,
        message: Any? = null
    )
}