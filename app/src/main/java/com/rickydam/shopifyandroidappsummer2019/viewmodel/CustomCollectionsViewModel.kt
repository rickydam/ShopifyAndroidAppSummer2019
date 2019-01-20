package com.rickydam.shopifyandroidappsummer2019.viewmodel

import android.arch.lifecycle.ViewModel
import com.rickydam.shopifyandroidappsummer2019.data.remote.ShopifyAPI
import javax.inject.Inject

class CustomCollectionsViewModel : BaseViewModel() {
    @Inject
    lateinit var shopifyAPI: ShopifyAPI
}
