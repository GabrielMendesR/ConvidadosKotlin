package com.caderno.convidados.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.caderno.convidados.model.GuestModel
import com.caderno.convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    fun insert(guest: GuestModel) {
        repository.insert(guest)
    }

}