package com.sharedcalendar.utility

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.muddzdev.styleabletoast.StyleableToast
import com.sharedcalendar.R
import kotlinx.android.synthetic.main.activity_calendar.view.*
import java.text.SimpleDateFormat
import java.util.*

fun hideKeyboard(activity: Activity) {
    val view = activity.currentFocus
    (activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
        hideSoftInputFromWindow(view?.windowToken, 0)
    }
}

fun showMessage(context: Context, massage: String) =
    Toast.makeText(context, massage, Toast.LENGTH_LONG).show()

fun String.convertTimestamp(): Date {
    val parseFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return parseFormat.parse(this)
}

fun Date.convertToday(): String {
    val resultFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return resultFormat.format(this)
}

fun View.toggleVisibility() {
    visibility = if (visibility == View.VISIBLE) View.GONE else View.VISIBLE
}

fun Context.checkInternetConnection(): Boolean {
    val connectivityManager =
        applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
    return if (isConnected) {
        true
    } else {
        StyleableToast.makeText(
            applicationContext,
            getString(R.string.no_internet_connection),
            Toast.LENGTH_LONG,
            R.style.myToastNoInternet
        ).show()
        false
    }
}

fun Context.startSound(sound: Int) = MediaPlayer.create(this, sound).start()

fun AppCompatActivity.hideStatusBar() = window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)

fun View.setMonthImage(
    currentMonth: Int
) {
    when (currentMonth) {
        0 -> calendar_activity_image_id.setImageResource(R.drawable.background0)
        1 -> calendar_activity_image_id.setImageResource(R.drawable.background1)
        2 -> calendar_activity_image_id.setImageResource(R.drawable.background2)
        3 -> calendar_activity_image_id.setImageResource(R.drawable.background3)
        4 -> calendar_activity_image_id.setImageResource(R.drawable.background4)
        5 -> calendar_activity_image_id.setImageResource(R.drawable.background5)
        6 -> calendar_activity_image_id.setImageResource(R.drawable.background6)
        7 -> calendar_activity_image_id.setImageResource(R.drawable.background7)
        8 -> calendar_activity_image_id.setImageResource(R.drawable.background8)
        9 -> calendar_activity_image_id.setImageResource(R.drawable.background9)
        10 -> calendar_activity_image_id.setImageResource(R.drawable.background10)
        11 -> calendar_activity_image_id.setImageResource(R.drawable.background11)
    }
}

fun ConstraintLayout.setMonthBackground(
    currentMonth: Int,
    context: Context
) {
    when (currentMonth) {
        0 -> background = context.getDrawable(R.color.colorBackground0)
        1 -> background = context.getDrawable(R.color.colorBackground1)
        2 -> background = context.getDrawable(R.color.colorBackground2)
        3 -> background = context.getDrawable(R.color.colorBackground3)
        4 -> background = context.getDrawable(R.color.colorBackground4)
        5 -> background = context.getDrawable(R.color.colorBackground5)
        6 -> background = context.getDrawable(R.color.colorBackground6)
        7 -> background = context.getDrawable(R.color.colorBackground7)
        8 -> background = context.getDrawable(R.color.colorBackground8)
        9 -> background = context.getDrawable(R.color.colorBackground9)
        10 -> background = context.getDrawable(R.color.colorBackground10)
        11 -> background = context.getDrawable(R.color.colorBackground11)
    }
}

fun Context.startVibration(duration: Long) {
    val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (vibrator.hasVibrator()) {
        vibrator.vibrate(
            VibrationEffect.createOneShot(
                duration,
                VibrationEffect.DEFAULT_AMPLITUDE
            )
        )
    }
}