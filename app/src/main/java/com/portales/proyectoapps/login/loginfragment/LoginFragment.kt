package com.portales.proyectoapps.login.loginfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
