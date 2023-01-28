package com.example.coordinator.di

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named

enum class CoordinatorQualifiers(val qualifier: Qualifier) {
    MAIN(named("MAIN")),
    SPLASH(named("SPLASH")),
    QR_CODE_SCANNER(named("QR_CODE_SCANNER"))
}