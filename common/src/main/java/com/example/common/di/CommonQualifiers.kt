package com.example.common.di

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named

enum class CommonQualifiers(val qualifier: Qualifier) {
    SCOPE_FOR_WRITE_OPERATIONS(named("SCOPE_FOR_WRITE_OPERATIONS"))
}