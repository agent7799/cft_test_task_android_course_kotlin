package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var cardBin = 0
    private val historyRequests = ArrayList<String>()
    private lateinit var shared: SharedPreferences
    private var stringArrayAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shared = this.getSharedPreferences("com.example.myapplication", MODE_PRIVATE)
        findViewById<Button>(R.id.about_button)
        findViewById<Button>(R.id.clear_history_button)
        val editText = findViewById<EditText>(R.id.editTextNumberSigned)
        val historyList = findViewById<ListView>(R.id.historyListView)


        stringArrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, historyRequests
        )

        historyList.adapter = stringArrayAdapter

        historyList.onItemClickListener =
            OnItemClickListener { _, itemClicked, _, _ ->
                val textView = itemClicked as TextView
                val strText = textView.text.toString() // получаем текст нажатого элемента
                cardBin = strText.toInt()
                val intent = Intent(this@MainActivity, PlainActivity::class.java)
                intent.putExtra("cardBIN", cardBin)
                startActivity(intent)
            }

        findViewById<View>(R.id.about_button).setOnClickListener {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.clear_history_button).setOnClickListener {
            historyRequests.clear()
            stringArrayAdapter!!.notifyDataSetChanged()
        }

        editText.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val temp = editText.text.toString()
                if (temp != "") {
                    historyRequests.add(temp)
                    stringArrayAdapter!!.notifyDataSetChanged()
                    cardBin = temp.toInt()
                    //                            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                    val intent = Intent(this@MainActivity, PlainActivity::class.java)
                    intent.putExtra("cardBIN", cardBin)
                    saveSharedPreferences()
                    editText.setText("")
                    startActivity(intent)
                    return@OnKeyListener true
                }
            }
            false
        }
        )
    }

    override fun onClick(view: View) {}

    override fun onStart() {
        super.onStart()
        retrieveSharedValue()
        Log.d("onStart", "onStart $historyRequests")
    }

    override fun onPostResume() {
        super.onPostResume()
        retrieveSharedValue()
        Log.d("onPostResume", "onStart $historyRequests")
    }

    override fun onPause() {
        super.onPause()
        saveSharedPreferences()
        Log.d("onPause", "onStart $historyRequests")
    }

    override fun onStop() {
        super.onStop()
        saveSharedPreferences()
        Log.d("onStop", "onStop $historyRequests")
    }

    private fun saveSharedPreferences() {
        val editor = shared.edit()
        editor.clear()
        val set: MutableSet<String> = HashSet()
        set.addAll(historyRequests)
        editor.putStringSet("key", set)
        editor.apply()
        Log.d("saveSharedPreferences", "history set$set")
    }

    private fun retrieveSharedValue() {
        val set = shared.getStringSet("key", setOfNotNull())
        historyRequests.clear()
        historyRequests.addAll(set!!)
        Log.d("retrieveSharedValue", "history array$historyRequests")
        stringArrayAdapter!!.notifyDataSetChanged()
    }
}