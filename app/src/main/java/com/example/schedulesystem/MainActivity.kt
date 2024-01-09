package com.example.schedulesystem

import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert.DATA
import androidx.appcompat.app.AppCompatActivity
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        run()
    }

    private fun run() {
        println(sendGet("http://localhost:8088/demo/first"))
    }

    private fun sendGet(url: String): String {
        val client = OkHttpClient().newBuilder()
            .connectTimeout(180, TimeUnit.SECONDS)
            .readTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .build()
        val request: Request = Request.Builder()
            .url(url)
            .get()
            .build()
        val response: Response
        val result: String
        try {
            response = client.newCall(request).execute()
            result = response.body!!.string()
        } catch (e: IOException) {
            throw IOException(DATA, e)
        }
        return result
    }
}