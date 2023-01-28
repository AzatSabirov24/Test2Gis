package com.example.qr_code_scanner.di

import com.example.coordinator.FeatureCoordinatorToFragment
import com.example.coordinator.di.CoordinatorQualifiers
import com.example.qr_code_scanner.presentation.coordinator.QrCodeScannerCoordinator
import org.koin.dsl.module

val qrCodeScannerModule = module {
    single<FeatureCoordinatorToFragment>(CoordinatorQualifiers.QR_CODE_SCANNER.qualifier) {
        QrCodeScannerCoordinator()
    }
}