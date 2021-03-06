package com.rickydam.shopifyandroidappsummer2019.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.rickydam.shopifyandroidappsummer2019.R
import com.rickydam.shopifyandroidappsummer2019.data.remote.ShopifyAPI
import com.rickydam.shopifyandroidappsummer2019.model.CustomCollection
import com.rickydam.shopifyandroidappsummer2019.view.adapter.CollectionListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CustomCollectionsListViewModel : BaseViewModel() {
    @Inject
    lateinit var shopifyAPI: ShopifyAPI

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadCustomCollections() }

    val collectionListAdapter: CollectionListAdapter = CollectionListAdapter()

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
                { result -> onRetrieveCustomCollectionsSuccess(result) },
                { onRetrieveCustomCollectionsError() }
            )
    }

    private fun onRetrieveCustomCollectionsStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveCustomCollectionsFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveCustomCollectionsSuccess(customCollection: CustomCollection) {
        collectionListAdapter.updateCollectionList(customCollection.collections)
    }

    private fun onRetrieveCustomCollectionsError() {
        errorMessage.value = R.string.custom_collections_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}