package com.rickydam.shopifyandroidappsummer2019.injection.module

import com.rickydam.shopifyandroidappsummer2019.data.remote.ShopifyAPI
import com.rickydam.shopifyandroidappsummer2019.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Module which provides all required dependencies about the network.
 */
@Module
object NetworkModule {
    /**
     * Provides the Shopify API service implementation.
     * @param retrofit The Retrofit object used to instantiate the service
     * @return The Shopify API service implementation
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideShopifyApi(retrofit: Retrofit): ShopifyAPI {
        return retrofit.create(ShopifyAPI::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return The Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}