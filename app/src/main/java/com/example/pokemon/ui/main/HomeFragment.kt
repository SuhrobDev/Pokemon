package com.example.pokemon.ui.main

import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemon.App
import com.example.pokemon.R
import com.example.pokemon.databinding.FragmentHomeBinding
import com.example.pokemon.ui.BaseFragment
import com.example.pokemon.ui.main.adapter.PakemonPagerAdapter
import com.example.pokemon.utils.MenuType
import com.example.pokemon.utils.SharedPref
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    @Inject
    lateinit var viewModel: HomeViewModel

    private val adapter by lazy {
        PakemonPagerAdapter(requireContext())
    }

    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    private lateinit var sharedPref: SharedPref


    @ExperimentalPagingApi
    override fun onViewCreate() {
        App.appComponent.inject(this)
        sharedPref = SharedPref(requireContext())
        binding.rv.adapter = adapter
        adapter.manager = sharedPref.getType()

        when (sharedPref.getType()) {
            0 -> setManagerLinear()
            1 -> setManagerGrid()
            2 -> setManagerGrid1()
        }

        select()
        click()
        fromDb()
    }

    private fun select() {
        val menu = MenuType(requireContext(), binding.menu)

        binding.menu.setOnClickListener {
            menu.show()
        }

        menu.setGrid1ClickListener {
            setManagerGrid1()
        }

        menu.setGridClickListener {
            setManagerGrid()
        }

        menu.setLinearClickListener {
            setManagerLinear()
        }
    }

    private fun click() {
        binding.search.setOnClickListener {
            navController.navigate(R.id.searchFragment)
        }
        adapter.setItemClickListener {
            Log.d("SSSSSSSSSSSK", "bundle: $it")
            navController.navigate(R.id.detailsFragment, bundleOf("ITEMID" to it))
        }
    }

    private fun setManagerGrid1() {
        val mGridLayoutManager =
            GridLayoutManager(requireContext(), 3) // (Context context, int spanCount)
        binding.rv.layoutManager = mGridLayoutManager
        adapter.manager = 2
        sharedPref.setType(2)
    }

    private fun setManagerGrid() {
        val mGridLayoutManager =
            GridLayoutManager(requireContext(), 2) // (Context context, int spanCount)
        binding.rv.layoutManager = mGridLayoutManager
        adapter.manager = 1
        sharedPref.setType(1)
    }

    private fun setManagerLinear() {
        val mLinearLayoutManagerHorizontal =
            LinearLayoutManager(requireContext()) // (Context context)
        mLinearLayoutManagerHorizontal.orientation = LinearLayoutManager.VERTICAL
        binding.rv.layoutManager = mLinearLayoutManagerHorizontal
        adapter.manager = 0
        sharedPref.setType(0)
    }

    @ExperimentalPagingApi
    private fun fromDb() {
        lifecycleScope.launch(coroutineExceptionHandler) {
            viewModel.getAllDogs().collect {
                adapter.submitData(it)
            }
        }
    }

}