package com.example.pokemon.ui

//import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.util.InetAddressUtils
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.pokemon.MainActivity
import com.google.android.material.animation.AnimationUtils
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialElevationScale

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        onViewCreate()
    }

    abstract fun onViewCreate()

    fun showMainProgress() {
        (activity as MainActivity).showProgress()
    }

    fun hideMainProgress() {
        (activity as MainActivity).hideProgress()
    }
//
//    fun showStartProgress() {
//        (activity as StartActivity).showProgress()
//    }
//
//    fun hideStartProgress() {
//        (activity as StartActivity).hideProgress()
//    }
//
//    fun hidePodcast() {
//        (activity as MainActivity).hidePodcast()
//    }
//
//    fun showPodcast() {
//        (activity as MainActivity).showPodcast()
//    }
//
//    fun getListMusic() {
//        (activity as MainActivity)
//    }

    fun getDeviceName(): String = Build.MODEL

    @SuppressLint("RestrictedApi")
    fun transitionAnimForItem() {
        val transformation = MaterialContainerTransform()
        transformation.interpolator = AnimationUtils.LINEAR_INTERPOLATOR
        sharedElementEnterTransition = MaterialElevationScale(true).apply {
            duration = 300
        }
        exitTransition = MaterialElevationScale(true).apply {
            duration = 300
        }
//        @SuppressLint("RestrictedApi")
//        fun transitionAnimForItem() {
//        val transformation = MaterialContainerTransform()
//        transformation.interpolator = AnimationUtils.LINEAR_INTERPOLATOR

//        sharedElementEnterTransition = activity?.let { TransitionInflater.from(it).inflateTransition(
//            R.transition.image_shared_element_transition) }
//
//        sharedElementReturnTransition = activity?.let { TransitionInflater.from(it).inflateTransition(
//            R.transition.grid_exit_transition) }

//        sharedElementEnterTransition = MaterialElevationScale(true).apply {
//            duration = 300
//        }
//        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z,true)
//
//        exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z,true)
//
//        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Z,true)

    }


}

