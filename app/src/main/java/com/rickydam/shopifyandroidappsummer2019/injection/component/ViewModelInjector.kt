package com.rickydam.shopifyandroidappsummer2019.injection.component

import com.rickydam.shopifyandroidappsummer2019.injection.module.NetworkModule
import com.rickydam.shopifyandroidappsummer2019.viewmodel.CustomCollectionsViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for ViewModels.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified CustomCollectionsViewModel
     * @param customCollectionsViewModel VM in which to inject the dependencies
     */
    fun inject(customCollectionsViewModel: CustomCollectionsViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}