package com.portales.proyectoapps.login.registerfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    val RegisterUseCase = RegisterUseCase()

    fun register(model: RegisterModel){
        RegisterUseCase.register(model)
    }

}