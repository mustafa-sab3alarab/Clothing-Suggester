package com.example.clothingsuggester.util

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.clothingsuggester.databinding.DialogBinding

class Dialog(
    context: Context,
    title: String,
    description: String,
    buttonText: String,
    onClick: (view: View) -> Unit
) {

    private val alertDialog: AlertDialog
    private val binding: DialogBinding

    init {
        val alertBuilder = AlertDialog.Builder(context)
        binding = DialogBinding.inflate(LayoutInflater.from(context))

        alertBuilder.setView(binding.root)

        binding.textViewTitle.text = title
        binding.textViewDescription.text = description
        binding.buttonPositive.text = buttonText
        binding.buttonPositive.setOnClickListener {
            onClick(it)
        }

        alertDialog = alertBuilder.create()
        alertDialog.setCancelable(false)
    }

    fun show() {
        alertDialog.show()
    }

    fun dismiss() {
        alertDialog.dismiss()
    }
}