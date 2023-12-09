package com.example.apiquest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.apiquest.sampledata.ApiTask
import com.example.apiquest.sampledata.ApiCallback
import org.json.JSONException
import org.json.JSONObject

class APIRestActivity : AppCompatActivity(), ApiCallback {
    private lateinit var apiTask: ApiTask
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apirest)
        apiTask = ApiTask(this)
        var button = findViewById<Button>(R.id.btn)

        button.setOnClickListener{
            apiTask.execute("https://zelda.fanapis.com/api/games?limit=2")
        }
    }

    override fun onRequestComplete(result: String) {
        var text = findViewById<TextView>(R.id.ApiTextView)

        text.text = result;
    }
}