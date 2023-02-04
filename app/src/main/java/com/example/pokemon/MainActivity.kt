package com.example.pokemon

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.utils.gone
import com.example.pokemon.utils.visible


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        App.appComponent.inject(this)
        nav()

    }

    private fun nav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        controller = navHostFragment.findNavController()
    }

    fun showProgress() = binding.apply {
        binding.progress.visible()
    }

    fun hideProgress() = binding.apply {
        binding.progress.gone()
    }

//    override fun onDestroy() {
//        super.onDestroy()
////        DatabaseKotlin().getDatabase()?.close()
//        Database.getDatabase().close()
//    }
}