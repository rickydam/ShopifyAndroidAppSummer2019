package com.rickydam.shopifyandroidappsummer2019.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.rickydam.shopifyandroidappsummer2019.R
import com.rickydam.shopifyandroidappsummer2019.databinding.ItemCollectionBinding
import com.rickydam.shopifyandroidappsummer2019.model.Collection
import com.rickydam.shopifyandroidappsummer2019.viewmodel.CollectionViewModel

class CollectionListAdapter: RecyclerView.Adapter<CollectionListAdapter.ViewHolder>() {

    private lateinit var collectionList: List<Collection>

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding: ItemCollectionBinding = DataBindingUtil.inflate(
            LayoutInflater.from(p0.context), R.layout.item_collection, p0, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(collectionList[p1])
    }

    override fun getItemCount(): Int {
        return if(::collectionList.isInitialized) collectionList.size else 0
    }

    fun updateCollectionList(collectionList: List<Collection>) {
        this.collectionList = collectionList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemCollectionBinding): RecyclerView.ViewHolder(binding.root) {
        private val collectionViewModel = CollectionViewModel()

        fun bind(collection: Collection) {
            collectionViewModel.bind(collection)
            binding.collectionViewModel = collectionViewModel
        }
    }
}