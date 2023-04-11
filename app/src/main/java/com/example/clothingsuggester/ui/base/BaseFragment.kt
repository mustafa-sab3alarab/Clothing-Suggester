package com.example.clothingsuggester.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    abstract val LOG_TAG: String

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    abstract val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater, requireNotNull(container), false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected fun log(value: String) {
        Log.v(LOG_TAG, value)
    }

}