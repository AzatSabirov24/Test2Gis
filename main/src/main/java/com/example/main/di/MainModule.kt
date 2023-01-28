package com.example.main.di

import androidx.fragment.app.FragmentActivity
import com.example.coordinator.FeatureCoordinator
import com.example.coordinator.di.CoordinatorQualifiers
import com.example.main.presentation.activity.MainActivity
import com.example.main.presentation.coordinator.MainCoordinator
import com.example.main.presentation.router.MainRouter
import org.koin.dsl.module

val mainModule = module {
    single<FeatureCoordinator>(CoordinatorQualifiers.MAIN.qualifier) {
        MainCoordinator()
    }
    factory { params ->
        MainRouter(
            activity = params.get<FragmentActivity>() as FragmentActivity,
            fragmentContainerID = params.get<Int>() as Int,
            qrCodeScannerCoordinator = get(CoordinatorQualifiers.QR_CODE_SCANNER.qualifier)
        )
    }
}