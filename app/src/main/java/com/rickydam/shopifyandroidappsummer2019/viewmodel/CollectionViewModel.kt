package com.rickydam.shopifyandroidappsummer2019.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.rickydam.shopifyandroidappsummer2019.model.Collection

class CollectionViewModel: BaseViewModel() {
    private val collectionTitle = MutableLiveData<String>()
    private val collectionBody = MutableLiveData<String>()

    fun bind(collection: Collection){
        collectionTitle.value = collection.title
        collectionBody.value = collection.body_html
    }

    fun getCollectionTitle():MutableLiveData<String>{
        return collectionTitle
    }

    fun getCollectionBody():MutableLiveData<String>{
        return collectionBody
    }
}