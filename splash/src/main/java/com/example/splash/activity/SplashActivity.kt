package com.example.splash.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.splash.router.SplashRouter
import org.koin.android.ext.android.inject

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val router: SplashRouter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router.openMainActivity(this)
    }
}