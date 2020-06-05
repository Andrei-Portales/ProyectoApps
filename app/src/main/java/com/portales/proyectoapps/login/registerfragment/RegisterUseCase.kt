package com.portales.proyectoapps.login.registerfragment

class RegisterUseCase {

    private val RegisterRepository = RegisterRepository()

    fun register(model: RegisterModel){
        RegisterRepository.Register(model)
    }

}