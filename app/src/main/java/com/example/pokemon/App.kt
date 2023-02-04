package com.example.pokemon

import android.app.Application
import android.content.res.Resources
import com.example.pokemon.di.component.AppComponent
import com.example.pokemon.di.component.DaggerAppComponent
import com.example.pokemon.di.module.*
import com.orhanobut.hawk.Hawk


class App : Application() {
    companion object {
        lateinit var resource: Resources
        lateinit var appComponent: AppComponent
//        lateinit var sharedPref: EncryptedSharedPref
    }

    override fun onCreate() {
        super.onCreate()
        resource = resources
//        Database.init(this).createDatabase().open()

//        sharedPref = EncryptedSharedPref(applicationContext)
//        Log.d("OOOOOOOOOOOOOOOOOOOO", "onViewCreate: ${sharedPref.getNightMode()}")
//
//        if (sharedPref.getNightMode()) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        }
//

        appComponent = DaggerAppComponent.builder().networkModule(NetworkModule(this))
            .repositoryModule(RepositoryModule()).apiServiceModule(ApiServiceModule())
            .dataSourceModule(DataSourceModule()).databaseModule(DatabaseModule(this)).build()

//        sharedPref = EncryptedSharedPref(applicationContext)
//        Log.d("OOOOOOOOOOOOOOOOOOOO", "onViewCreate: ${sharedPref.getNightMode()}")

//        if (sharedPref.getNightMode()) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        }

        Hawk.init(this).build()

//        if (sharedPref.getLanguage() == "") {
//            sharedPref.setLanguage("3")
//            Hawk.put("pref_lang", "ru")
//        } else {
//            Hawk.put("pref_lang", sharedPref.getLanguage())
//        }
    }
}