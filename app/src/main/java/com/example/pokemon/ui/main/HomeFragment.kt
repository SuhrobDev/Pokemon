package com.example.pokemon.ui.main

import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import com.example.pokemon.App
import com.example.pokemon.R
import com.example.pokemon.databinding.FragmentHomeBinding
import com.example.pokemon.ui.BaseFragment
import com.example.pokemon.ui.main.adapter.PakemonPagerAdapter
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    @Inject
    lateinit var viewModel: HomeViewModel

    private val adapter by lazy {
        PakemonPagerAdapter(requireContext())
    }

    @ExperimentalPagingApi
    override fun onViewCreate() {
        App.appComponent.inject(this)
        binding.rv.adapter = adapter
        click()

        fromDb()
    }

    private fun click() {
        adapter.setItemClickListener {
            Log.d("SSSSSSSSSSSK", "bundle: $it")
            navController.navigate(R.id.detailsFragment, bundleOf("ITEMID" to it))
        }
    }

    @ExperimentalPagingApi
    private fun fromDb() {
        lifecycleScope.launchWhenStarted {
            viewModel.getAllDogs().collect {
                adapter.submitData(it)
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.getMainPaging().collect {
                adapter.submitData(it)
            }
        }
    }

}