package com.example.androidconcurrency2020

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.example.androidconcurrency2020.action.FOO"

private const val EXTRA_PARAM1 = "com.example.androidconcurrency2020.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.example.androidconcurrency2020.extra.PARAM2"

class MyIntentService : IntentService("MyIntentService") {

    companion object {

        fun startActionFoo(context: Context, param1: String, param2: String): Intent =
            Intent(context, MyIntentService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
    }

    override fun onHandleIntent(intent: Intent?) {
        println("MyIntentService.onHandleIntent")
    }
}
