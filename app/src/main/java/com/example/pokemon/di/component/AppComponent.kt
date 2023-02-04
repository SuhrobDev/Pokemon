package com.example.pokemon.di.component

import com.example.pokemon.MainActivity
import com.example.pokemon.di.module.*
import com.example.pokemon.ui.by_id.DetailsFragment
import com.example.pokemon.ui.main.HomeFragment
import com.example.pokemon.ui.main.search.SearchFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [
        ApiServiceModule::class,
        DataSourceModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        DatabaseModule::class
//        ServiceModule::class,
//        OtherModule::class,
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(homeFragment: DetailsFragment)
    fun inject(homeFragment: SearchFragment)

}