package com.example.splash.di

import com.example.coordinator.di.CoordinatorQualifiers
import com.example.splash.coordinator.SplashCoordinator
import com.example.splash.router.SplashRouter
import org.koin.dsl.module

val splashModule = module {
    single { SplashCoordinator() }
    single { SplashRouter(get(CoordinatorQualifiers.MAIN.qualifier)) }
}