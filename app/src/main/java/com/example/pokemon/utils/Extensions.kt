package com.example.pokemon.utils

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pokemon.App.Companion.resource
import com.example.pokemon.R

fun getString(@StringRes int: Int) = resource.getString(int)

fun getString(@StringRes int: Int, str: String) = resource.getString(int, str)

fun ImageView.setSvgColor(@ColorRes color: Int) =
    setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_IN)

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun Fragment.popBackStack() {
    findNavController().popBackStack()
}

fun Fragment.navigate(id: Int) {
    findNavController().navigate(id)
}

fun Fragment.navigateWithArgs(id: Int, bundle: Bundle) {
    findNavController().navigate(id, bundle)
}

fun getColor(context: Context, color: Int): Int {
    return ContextCompat.getColor(
        context,
        color
    )
}

//fun Fragment.toMainActivity() {
//    (activity as StartActivity).toMainActivity()
//}

//fun animateToolBarTittle(view: View) {
//    YoYo.with(Techniques.BounceInRight)
//        .duration(1300)
//        .repeat(0)
//        .playOn(view)
//}

fun ImageView.loadImage(context: Context, path: String) {
    Glide.with(context).load(getString(R.string.img_url) + path)
        .into(this)
}

//fun TextView.setStatusColor(status: String) {
//    when (status) {
//        "completed" -> {
//            this.setBackgroundResource(R.drawable.completed)
//        }
//        "pending" -> {
//            this.setBackgroundResource(R.drawable.to_do)
//        }
//        "progress" -> {
//            this.setBackgroundResource(R.drawable.in_progress)
//        }
//        "uncompleted" -> {
//            this.setBackgroundResource(R.drawable.to_do)
//        }
//    }
//}

//fun TextView.setStatus(status: String) {
//    when (status) {
//        "completed" -> {
//            this.text = getString(R.string.completed)
//        }
//        "pending" -> {
//            this.text = getString(R.string.to_do)
//        }
//        "progress" -> {
//            this.text = getString(R.string.in_progress)
//        }
//        "uncompleted" -> {
//            this.text = getString(R.string.uncompleted)
//        }
//    }
//}

fun TextView.setStatusTextColor(status: String) {
    when (status) {
        "completed" -> {
            this.setTextColor(Color.parseColor("#47C272"))
        }
        "pending" -> {
            this.setTextColor(Color.parseColor("#396EF1"))
        }
        "progress" -> {
            this.setTextColor(Color.parseColor("#FF8A00"))
        }
        "uncompleted" -> {
            this.setTextColor(Color.parseColor("#47C272"))
        }
    }

}

fun View.getStatusTextColor(status: String) {
    when (status) {
        "completed" -> {
            this.setBackgroundColor(Color.parseColor("#47C272"))
        }
        "pending" -> {
            this.setBackgroundColor(Color.parseColor("#396EF1"))
        }
        "progress" -> {
            this.setBackgroundColor(Color.parseColor("#FF8A00"))
        }
        "uncompleted" -> {
            this.setBackgroundColor(Color.parseColor("#47C272"))
        }
    }

}
//
//fun List<TaskListsModel>.filterStatus(status: String): List<TaskListsModel> {
//    return when (status) {
//        getString(R.string.completed) -> {
//            this.filter {
//                (it.type == "pending")
//                (it.type == "progress")
//                (it.type == "uncompleted")
//            }
//        }
//        getString(R.string.to_do) -> {
//            this.filter {
//                (it.type == "completed")
//                (it.type == "progress")
//                (it.type == "uncompleted")
//            }
//        }
//        getString(R.string.in_progress) -> {
//            this.filter {
//                (it.type == "pending")
//                (it.type == "completed")
//                (it.type == "uncompleted")
//            }
//        }
//        else -> {
//            this
//        }
//    }
//}

//
//fun getLocation(
//    context: Context,
//    data: (address: String, lat: Double, long: Double) -> Unit
//) {
//    val client = LocationServices.getFusedLocationProviderClient(context)
//    val geocoder = Geocoder(context, Locale.getDefault())
//    if (ActivityCompat.checkSelfPermission(
//            context,
//            Manifest.permission.ACCESS_FINE_LOCATION
//        ) == PackageManager.PERMISSION_GRANTED
//    ) {
//        client.lastLocation.addOnSuccessListener { location ->
//            if (location != null) {
//                try {
//                    val addresses = geocoder.getFromLocation(
//                        location.latitude,
//                        location.longitude,
//                        5
//                    )
//                    val country = addresses?.get(0)?.countryName
//                    val city = addresses?.get(0)?.locality
//                    val ad = "$city, $country"
//                    data.invoke(
//                        ad,
//                        location.latitude,
//                        location.longitude
//                    )
//
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//            }
//        }
//    }
//}
//
//fun getMonth(int: Int, year: Int): String {
//    var date = ""
//    date = when (int) {
//        0 -> getString(R.string.january) + " " + year.toString()
//        1 -> getString(R.string.february) + " " + year.toString()
//        2 -> getString(R.string.march) + " " + year.toString()
//        3 -> getString(R.string.april) + " " + year.toString()
//        4 -> getString(R.string.may) + " " + year.toString()
//        5 -> getString(R.string.june) + " " + year.toString()
//        6 -> getString(R.string.july) + " " + year.toString()
//        7 -> getString(R.string.august) + " " + year.toString()
//        8 -> getString(R.string.september) + " " + year.toString()
//        9 -> getString(R.string.october) + " " + year.toString()
//        10 -> getString(R.string.november) + " " + year.toString()
//        11 -> getString(R.string.december) + " " + year.toString()
//        else -> getString(R.string.january) + " " + year.toString()
//    }
//    return date
//}

//fun getMonth(int: String): Int {
//    var date = 0
//
//    date = when (int) {
//        getString(R.string.january) -> 1
//        getString(R.string.february) -> 2
//        getString(R.string.march) -> 3
//        getString(R.string.april) -> 4
//        getString(R.string.may) -> 5
//        getString(R.string.june) -> 6
//        getString(R.string.july) -> 7
//        getString(R.string.august) -> 8
//        getString(R.string.september) -> 9
//        getString(R.string.october) -> 10
//        getString(R.string.november) -> 11
//        getString(R.string.december) -> 12
//        else -> 1
//    }
//    return date
//}