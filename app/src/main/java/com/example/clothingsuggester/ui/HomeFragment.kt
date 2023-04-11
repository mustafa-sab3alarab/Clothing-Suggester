package com.example.clothingsuggester.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clothingsuggester.databinding.FragmentHomeBinding
import com.example.clothingsuggester.ui.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val LOG_TAG: String
        get() = this::class.java.simpleName

    override val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        log("on View Created")
    }

}