package com.portales.proyectoapps.Login.Fragments.RegisterFragment

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.navigation.Navigation
import com.portales.proyectoapps.R
import kotlinx.android.synthetic.main.fragment_register.view.*
import java.util.*


class RegisterFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    private lateinit var vista:View
    private lateinit var listener: View.OnClickListener
    private val dateListener :  DatePickerDialog.OnDateSetListener = this


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_register, container, false)
        activity?.title = activity?.getString(R.string.registrarse)
        listener = ActionListener()
        botones()

        return vista
    }



    private fun botones(){
        vista.txtFechaLayout.setOnClickListener(listener)
        vista.txtYaCuenta.setOnClickListener(listener)
        vista.btnRegistrarse.setOnClickListener(listener)
    }


    inner class ActionListener() : View.OnClickListener {
        override fun onClick(v: View?) {
            when(v){
                vista.txtFechaLayout -> {
                    DatePickerDialog(context as Context, dateListener,
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show()
                }
                vista.txtYaCuenta -> {
                    Navigation.findNavController(vista).navigate(R.id.action_registerFragment_to_loginFragment)
                }
                vista.btnRegistrarse -> {
                    Navigation.findNavController(vista).navigate(R.id.action_registerFragment_to_loginFragment)
                }
            }
        }


    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        vista.txtFechaNacimiento.setText("${dayOfMonth}/${month}/${year}")
    }


}
