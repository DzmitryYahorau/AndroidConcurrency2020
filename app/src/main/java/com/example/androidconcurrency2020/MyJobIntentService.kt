package com.example.androidconcurrency2020

import android.app.Activity
import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver
import android.util.Log
import androidx.core.app.JobIntentService

// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.example.androidconcurrency2020.action.FOO"

private const val EXTRA_PARAM1 = "com.example.androidconcurrency2020.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.example.androidconcurrency2020.extra.PARAM2"
private const val RECEIVER_KEY = "com.example.androidconcurrency2020.extra.RECEIVER_KEY"

class MyJobIntentService : JobIntentService() {

    companion object {

        private const val JOB_ID = 1000

        fun startJob(context: Context, param1: String, param2: String, receiver: ResultReceiver) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_FOO
                putExtra(RECEIVER_KEY, receiver)
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            enqueueWork(context, MyJobIntentService::class.java, JOB_ID, intent)
        }
    }

    override fun onHandleWork(p0: Intent) {
        println("MyJobIntentService.onHandleWork")
    }
}


class MyResultReceiver(handler: Handler) : ResultReceiver(handler) {
    override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
        if (resultCode == Activity.RESULT_OK) {
            println("MyResultReceiver.onReceiveResult")
        }
    }
}
