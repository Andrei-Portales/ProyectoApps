package com.portales.proyectoapps.login.registerfragment

import android.app.Application
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import com.portales.proyectoapps.R
import com.portales.proyectoapps.databinding.FragmentRegisterBinding
import java.util.*


class RegisterFragment : Fragment(), DatePickerDialog.OnDateSetListener {


    private lateinit var listener: View.OnClickListener
    private val dateListener :  DatePickerDialog.OnDateSetListener = this
    private lateinit var binding :FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        binding.registerModel = RegisterModel()
        activity?.title = activity?.getString(R.string.registrarse)
        listener = ActionListener()
        botones()
        viewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application as Application).create(RegisterViewModel::class.java)
        return binding.root
    }



    private fun botones(){
        binding.txtFechaLayout.setOnClickListener(listener)
        binding.txtYaCuenta.setOnClickListener(listener)
        binding.btnRegistrarse.setOnClickListener(listener)
    }


    inner class ActionListener() : View.OnClickListener {
        override fun onClick(v: View?) {
            when(v){
                binding.txtFechaLayout -> {
                    DatePickerDialog(context as Context, dateListener,
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show()
                }
                binding.txtYaCuenta -> {
                    Navigation.findNavController(binding.root).navigate(R.id.action_registerFragment_to_loginFragment)
                }
                binding.btnRegistrarse -> {
                    if (binding.registerModel!!.isOk()){
                        viewModel.register(binding.registerModel!!)
                    }else{
                        Snackbar.make(binding.root, "Campos Invalidos", Snackbar.LENGTH_SHORT).show()
                    }
                }

            }
        }


    }



    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        binding.txtFechaNacimiento.setText("${dayOfMonth}/${month}/${year}")
    }




}
