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
    @GET("custom_collections.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    fun getCustomCollections(): Observable<List<CustomCollection>>
}