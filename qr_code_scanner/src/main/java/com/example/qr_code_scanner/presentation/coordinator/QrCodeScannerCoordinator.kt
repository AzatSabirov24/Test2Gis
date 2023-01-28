package com.example.qr_code_scanner.presentation.coordinator

import android.content.Context
import android.text.TextUtils.replace
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.coordinator.FeatureCoordinator
import com.example.coordinator.FeatureCoordinatorToFragment
import com.example.qr_code_scanner.presentation.fragment.QrCodeScannerFragment

class QrCodeScannerCoordinator : FeatureCoordinatorToFragment {

    override fun navigateToFeature(
        activity: FragmentActivity,
        fragmentContainerId: Int,
        requestKey: String?,
        message: Any?
    ) {
        activity.supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<QrCodeScannerFragment>(fragmentContainerId)
        }
    }
}