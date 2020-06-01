package com.portales.proyectoapps.Principal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.portales.proyectoapps.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navigationOptions()
        val action = ActionBarDrawerToggle(this, drawer_layout, toolbar,R.string.openDrawer,R.string.closeDrawer)
        drawer_layout.addDrawerListener(action)
        action.syncState()

    }

    private fun navigationOptions(){
        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_inicio -> {
                    findNavController(R.id.fragmentmain).navigate(R.id.inicioFragment)
                }

                R.id.nav_rutina_diaria -> {
                    findNavController(R.id.fragmentmain).navigate(R.id.rutinaDiariaFragment)
                }
                R.id.nav_publicar_rutina -> {
                    findNavController(R.id.fragmentmain).navigate(R.id.publicarRutinaFragment)
                }
                R.id.nav_rutinas_comunidad -> {
                     findNavController(R.id.fragmentmain).navigate(R.id.rutinasComunidadFragment)
                }
                R.id.nav_rutinas_favs -> {
                    findNavController(R.id.fragmentmain).navigate(R.id.rutinasFavoritasFragment)
                }
                R.id.nav_ajustes -> {
                    findNavController(R.id.fragmentmain).navigate(R.id.ajustesFragment)
                }
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}
