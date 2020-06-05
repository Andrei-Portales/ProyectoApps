package com.portales.proyectoapps.login.registerfragment

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterRepository {



    fun Register(model: RegisterModel){
        val mAuth = FirebaseAuth.getInstance()
        mAuth.createUserWithEmailAndPassword(model.email.toString(), model.cpassword.toString())
            .addOnCompleteListener {
                if (it.isSuccessful){
                    val db = FirebaseFirestore.getInstance()
                    val user = HashMap<String, Any?>()
                    user.put("name", model.name)
                    user.put("email", model.email)
                    user.put("password", model.password)
                    user.put("birth", model.birth)
                    user.put("weight", model.weight)
                    user.put("height", model.height)

                    db.collection("users").add(user)

                }
            }
    }


}