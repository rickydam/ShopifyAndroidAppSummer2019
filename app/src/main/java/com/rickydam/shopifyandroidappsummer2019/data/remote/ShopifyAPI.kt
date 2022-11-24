package com.rickydam.shopifyandroidappsummer2019.data.remote

import com.rickydam.shopifyandroidappsummer2019.model.CustomCollection
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface that provides Retrofit HTTP requests
 */
interface ShopifyAPI {
    /**
     * Get the list of CustomCollections from the Shopify API
     */
    @GET("custom_collections.json?page=1&access_token=SOME_TOKEN")
    fun getCustomCollections(): Observable<CustomCollection>
}