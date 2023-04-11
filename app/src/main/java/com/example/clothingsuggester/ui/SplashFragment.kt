package com.example.clothingsuggester.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clothingsuggester.databinding.FragmentSplashBinding
import com.example.clothingsuggester.ui.base.BaseFragment


class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override val LOG_TAG: String
        get() = this::class.java.simpleName

    override val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> FragmentSplashBinding
        get() = FragmentSplashBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        log("on View Created")
    }


}