package com.rickydam.shopifyandroidappsummer2019.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.rickydam.shopifyandroidappsummer2019.data.remote.ShopifyAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CustomCollectionsViewModel : BaseViewModel() {
    @Inject
    lateinit var shopifyAPI: ShopifyAPI

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init {
        loadCustomCollections()
    }

    private fun loadCustomCollections() {
        subscription = shopifyAPI.getCustomCollections()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveCustomCollectionsStart() }
            .doOnTerminate { onRetrieveCustomCollectionsFinish() }
            .subscribe(
                { onRetrieveCustomCollectionsSuccess() },
                { onRetrieveCustomCollectionsError() }
            )
    }

    private fun onRetrieveCustomCollectionsStart() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveCustomCollectionsFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveCustomCollectionsSuccess() {}

    private fun onRetrieveCustomCollectionsError() {}

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}