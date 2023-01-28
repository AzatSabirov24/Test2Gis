package com.example.main.presentation.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.common.viewmodel.GlobalSharedViewModel
import com.example.main.R
import com.example.main.presentation.router.MainRouter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private val globalSharedViewModel: GlobalSharedViewModel by viewModel()
    private val router: MainRouter by inject {
        parametersOf(this, R.id.activity_main_fragment)
    }
    private val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            updatePermissionsState()
        }
//    private lateinit var currentActiveFragmentObserver: Observer<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermissions.launch(permissions)

        println("---MainActivity")

        globalSharedViewModel.doSmth()

        val currentActiveFragmentObserver = Observer<Fragment> { currentFragment ->
            handleCurrentFragment(currentFragment)
        }
        router.currentActiveFragmentLD.observe(this, currentActiveFragmentObserver)

    }

    override fun onResume() {
        super.onResume()
        updatePermissionsState()
    }

    private fun handleCurrentFragment(currentFragment: Fragment) {
        println("----MainActivity->handleCurrentFragment->curFrag=${currentFragment}")
    }

    private fun updatePermissionsState() {
        val permissionsStates: Map<String, Boolean> = permissions.associateWith { permission ->
            ActivityCompat.checkSelfPermission(
                this,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }
        val notPermission = permissionsStates.any { (_, granted) -> !granted }
        if (notPermission)
            router.openNotPermissionsScreen(this)
        else
            router.openQrCodeScannerFragment()

    }

    companion object {

        private val permissions = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.POST_NOTIFICATIONS
        )
    }
}