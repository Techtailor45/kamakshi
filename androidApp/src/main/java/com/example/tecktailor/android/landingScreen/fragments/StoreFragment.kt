package com.example.tecktailor.android.landingScreen.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tecktailor.android.common.base.BaseFragment
import com.example.tecktailor.android.databinding.FragmentStoreBinding

class StoreFragment : BaseFragment<FragmentStoreBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentStoreBinding {
        return FragmentStoreBinding.inflate(inflater, container, false)
    }

    override fun fetchData() {
        // Fetch data if necessary
    }

    override fun setUpViews() {
        // Set up your views here
    }

    override fun setUpListeners() {
        // Set up your listeners here
    }
}
