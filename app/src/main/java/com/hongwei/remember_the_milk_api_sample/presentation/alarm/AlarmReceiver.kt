package com.hongwei.remember_the_milk_api_sample.presentation.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.hongwei.remember_the_milk_api_sample.ApiConfig
import com.hongwei.remember_the_milk_api_sample.ApiConfig.Alarm.KEY_NAME
import com.hongwei.remember_the_milk_api_sample.ApiConfig.Alarm.KEY_TYPE
import com.hongwei.remember_the_milk_api_sample.presentation.main.MainActivity


class AlarmReceiver : BroadcastReceiver() {
    companion object {
        const val TAG = "rtm.alarm-receiver"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val bundle = intent?.extras

        val type = bundle?.getString(KEY_TYPE)
        val name = bundle?.getString(KEY_NAME)

        Log.i(TAG, "-- Alarm received! type: $type, name: $name")

        when (type) {
            ApiConfig.AlarmType.TODO.id -> {
                NotificationLauncher.notify(context!!, "1 New Milk TODO!", name!!)
            }

            ApiConfig.AlarmType.WAKE_UP.id -> {
                context?.startActivity(MainActivity.intent(context))
                NotificationLauncher.notify(context!!, "A New Day!", "Good Morning!")
            }
        }
    }
}