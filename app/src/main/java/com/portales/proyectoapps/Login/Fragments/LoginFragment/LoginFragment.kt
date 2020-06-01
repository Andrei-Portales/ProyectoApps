package com.portales.proyectoapps.Login.Fragments.LoginFragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.portales.proyectoapps.Principal.MainActivity
import com.portales.proyectoapps.R

import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : Fragment() {

    private lateinit var vista: View
    private lateinit var listener: View.OnClickListener


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_login, container, false)
        listener = ActionListener()
        activity?.title = activity?.getString(R.string.iniciar_sesion)
        botones()
/*
        val LoginViewModel = ViewModelProviders.of(this)
            .get(LoginFragmentViewModel::class.java)

        DataBindingUtil.setContentView<FragmentLoginBinding>(activity as Activity,R.layout.fragment_login)
            .apply {
                this.lifecycleOwner = (this@LoginFragment)
                this.loginViewModel = LoginViewModel
            }

*/

        return vista
    }

    private fun botones(){
        vista.txtRegistrarse.setOnClickListener(listener)
        vista.btnIniciarSesion.setOnClickListener(listener)
    }



    inner class ActionListener : View.OnClickListener{

        override fun onClick(v: View?) {
            when(v){
                vista.txtRegistrarse -> { //Texto de registrarse
                    Navigation.findNavController(vista).navigate(R.id.action_loginFragment_to_registerFragment)
                }
                vista.btnIniciarSesion -> {
                    startActivity(Intent(context, MainActivity::class.java))
                    activity?.finish()
                }
            }
        }

    }

}
