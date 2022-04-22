package com.example.fogospt

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.fogospt.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        ativo

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(ativo, 20000)
    }

    private val sinalCor = arrayListOf(
        R.drawable.circle_reduzido,
        R.drawable.circle_moderado,
        R.drawable.circle_elevado,
        R.drawable.circle_muito_elevado,
        R.drawable.circle_maximo,
    )

    private val sinalWord = arrayListOf(
        "Reduzido",
        "Moderado",
        "Elevado",
        "Muito Elevado",
        "Máximo",
    )

    var num = 0
    val handler = Handler(Looper.getMainLooper())

    private val ativo = object: Runnable {
        override fun run() {
            num+= 1
            if (num == 5) {
                num = 0;
            }
            binding.appBarMain.riskCircle.setBackgroundResource(sinalCor[num])
            binding.appBarMain.riskCircle.text = sinalWord[num]
            handler.postDelayed(this, 20000)
            Log.i(TAG, "20 sec == $num")}
    }
}