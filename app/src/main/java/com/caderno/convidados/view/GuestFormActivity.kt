package com.caderno.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.caderno.convidados.viewModel.GuestFormViewModel
import com.caderno.convidados.R
import com.caderno.convidados.databinding.ActivityGuestFormBinding
import com.caderno.convidados.model.GuestModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[GuestFormViewModel::class.java]

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_save) {
            val name = binding.editName.text.toString()
            val presence = binding.radioPresent.isChecked

            val model = GuestModel(0, name, presence)
            viewModel.insert(model)
        }
    }
}