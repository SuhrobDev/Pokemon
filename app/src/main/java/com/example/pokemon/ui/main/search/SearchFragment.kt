package com.example.pokemon.ui.main.search

import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.pokemon.App
import com.example.pokemon.R
import com.example.pokemon.databinding.FragmentSearchBinding
import com.example.pokemon.ui.BaseFragment
import com.example.pokemon.utils.gone
import com.example.pokemon.utils.visible
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    @Inject
    lateinit var viewModel: SearchViewModel

    private var name = ""
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    override fun onViewCreate() {
        App.appComponent.inject(this)
        binding.line.gone()
        lifecycleScope.launch(coroutineExceptionHandler) {
            viewModel.getName("")
        }
        clickClose()
        sendText()

        viewLifecycleOwner.lifecycleScope.launch(coroutineExceptionHandler) {
            viewModel.search.collectLatest {
                it.data?.let { list ->
                    binding.searchNotFound.gone()
                    binding.line.visible()

                    Glide.with(requireContext())
                        .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${list.id}.png")
                        .into(binding.image)

                    binding.text.text = list.name
                    name = list.name

                    hideMainProgress()
                }
                if (it.error.isNotEmpty()) {
                    name = ""
                    binding.line.visibility = View.GONE
                    binding.searchNotFound.visibility = View.VISIBLE
                    Log.d("sdsjdskjfbjdbf", "onViewCreate: ${it.error}")
                    hideMainProgress()
                }
            }
        }

        binding.line.setOnClickListener {
            if (name.isNotEmpty()) {
                navController.navigate(
                    R.id.detailsFragment,
                    bundleOf("ITEMID" to name)
                )
            }
        }

        binding.image.setOnClickListener {
            if (name.isNotEmpty()) {
                navController.navigate(
                    R.id.detailsFragment,
                    bundleOf("ITEMID" to name)
                )
            }
        }
        binding.text.setOnClickListener {
            if (name.isNotEmpty()) {
                navController.navigate(
                    R.id.detailsFragment,
                    bundleOf("ITEMID" to name)
                )
            }
        }
    }

    private fun clickClose() = binding.close.setOnClickListener {
        binding.search.setText("")
        binding.close.gone()
        navController.popBackStack()
    }

    private fun close() = binding.apply {
        close.gone()
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private fun sendText() = binding.search.addTextChangedListener {
        binding.close.visible()
        if (it != null) {
            lifecycleScope.launch {
                viewModel.getName(it.trim().toString())
                Log.d("sdkjsdkjsd", "sendText: ${it.toString()}")
            }
        } else {
            lifecycleScope.launch(coroutineExceptionHandler) {
                viewModel.getName("")
            }
            name = ""
        }
    }

    override fun onResume() {
        super.onResume()
        close()
    }

    override fun onStop() {
        super.onStop()
        close()
    }

    override fun onStart() {
        super.onStart()
        close()
    }
}