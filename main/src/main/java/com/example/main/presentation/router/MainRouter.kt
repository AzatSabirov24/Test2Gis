package com.example.main.presentation.router

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coordinator.FeatureCoordinator
import com.example.coordinator.FeatureCoordinatorToFragment
import com.example.main.presentation.activity.MainActivity
import com.example.main.presentation.fragment.NotPermissionsFragment

internal class MainRouter(
    private val activity: FragmentActivity,
    private val fragmentContainerID: Int,
    private val qrCodeScannerCoordinator: FeatureCoordinatorToFragment,
) {

    private companion object {
        const val INCLUSIVE_FLAG = FragmentManager.POP_BACK_STACK_INCLUSIVE
    }

    private var _currentActiveFragmentLD = MutableLiveData<Fragment>()
    val currentActiveFragmentLD: LiveData<Fragment> = _currentActiveFragmentLD

    init {
        activity.supportFragmentManager.apply {
            addOnBackStackChangedListener {
                setCurrentActiveFragmentLD()
            }
            addFragmentOnAttachListener { _, _ ->
                if (this.findFragmentById(fragmentContainerID) != _currentActiveFragmentLD.value) {
                    setCurrentActiveFragmentLD()
                }
            }
        }
    }

    fun openQrCodeScannerFragment() {
        qrCodeScannerCoordinator.navigateToFeature(
            activity = activity,
            fragmentContainerId = fragmentContainerID
        )
    }

    fun openNotPermissionsScreen(
        activity: FragmentActivity
    ) {
        activity.supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<NotPermissionsFragment>(fragmentContainerID)
        }
    }

    fun openMainActivity(activity: FragmentActivity) {
        activity.startActivity(Intent(activity, MainActivity::class.java))
        activity.finish()
    }

    private fun setCurrentActiveFragmentLD() {
        _currentActiveFragmentLD.value =
            activity.supportFragmentManager.findFragmentById(fragmentContainerID)
    }
}