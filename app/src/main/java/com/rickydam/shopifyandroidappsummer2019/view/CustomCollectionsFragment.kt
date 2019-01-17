package com.rickydam.shopifyandroidappsummer2019.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rickydam.shopifyandroidappsummer2019.viewmodel.CustomCollectionsViewModel
import com.rickydam.shopifyandroidappsummer2019.R


class CustomCollectionsFragment : Fragment() {

    companion object {
        fun newInstance() = CustomCollectionsFragment()
    }

    private lateinit var viewModel: CustomCollectionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_collections_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CustomCollectionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
