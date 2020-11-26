package com.example.listaprodutos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.listaprodutos.MainViewModel
import com.example.listaprodutos.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.toolbarTitulo)
        supportActionBar!!.hide()

        navController = findNavController(R.id.navHost)

        appBarConfiguration = AppBarConfiguration(navController.graph)

        setupActionBarWithNavController(navController, appBarConfiguration)


        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.listaFragment -> {
                    supportActionBar!!.show()
                    toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}