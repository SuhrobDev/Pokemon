package com.example.pokemon.ui.by_id

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.pokemon.App
import com.example.pokemon.databinding.FragmentDetailsBinding
import com.example.pokemon.ui.BaseFragment
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {
    @Inject
    lateinit var viewModel: DetailsViewModel
    private var itemId: String = ""
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    override fun onViewCreate() {
        App.appComponent.inject(this)
        bundle()
        action()
    }

    private fun bundle() {
        val bundle: Bundle? = this.arguments
        bundle?.let {
            itemId = it.getString("ITEMID").toString()
            Log.d("SSSSSSSSSSSK", "bundle: $itemId")
            observe(itemId)
        }
    }

    private fun observe(id: String) {
        lifecycleScope.launch(coroutineExceptionHandler) {
            viewModel.getDetails(id = id)
        }
        lifecycleScope.launchWhenCreated {
            showMainProgress()
            viewModel.details.collectLatest {
                it.data?.let { podcastList ->
                    hideMainProgress()
                    binding.name.text = podcastList.name
                }
                if (it.error.isNotBlank()) {
                    hideMainProgress()
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun action() {
        binding.back.setOnClickListener {
            navController.popBackStack()
        }
    }
}