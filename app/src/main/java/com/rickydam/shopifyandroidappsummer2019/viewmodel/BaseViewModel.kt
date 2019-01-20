package com.rickydam.shopifyandroidappsummer2019.viewmodel

import android.arch.lifecycle.ViewModel
import com.rickydam.shopifyandroidappsummer2019.injection.component.DaggerViewModelInjector
import com.rickydam.shopifyandroidappsummer2019.injection.component.ViewModelInjector
import com.rickydam.shopifyandroidappsummer2019.injection.module.NetworkModule

abstract class BaseViewModel: ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is CustomCollectionsViewModel -> injector.inject(this)
        }
    }
}