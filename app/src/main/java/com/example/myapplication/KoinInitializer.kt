package com.example.myapplication

import android.content.Context
import androidx.startup.Initializer
import com.example.common.di.commonModule
import com.example.main.di.mainModule
import com.example.qr_code_scanner.di.qrCodeScannerModule
import com.example.splash.di.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class KoinInitializer : Initializer<KoinApplication> {

    override fun create(context: Context): KoinApplication = startKoin {
        androidContext(context)
        modules(
            listOf(splashModule, mainModule, qrCodeScannerModule, commonModule)
        )
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}