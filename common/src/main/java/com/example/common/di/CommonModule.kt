package com.example.common.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import com.example.common.viewmodel.GlobalSharedViewModel
import org.koin.dsl.module

val commonModule = module {
    single { GlobalSharedViewModel() }
    single(CommonQualifiers.SCOPE_FOR_WRITE_OPERATIONS.qualifier) {
        CoroutineScope(SupervisorJob() + Dispatchers.IO)
    }
}