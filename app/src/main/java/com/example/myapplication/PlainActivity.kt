package com.example.myapplication

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.data.Entity
import com.google.gson.Gson
import java.io.IOException
import java.net.URL


class PlainActivity : AppCompatActivity() {
    var bankUrView: TextView? = null
    var bankPhoneView: TextView? = null
    var plainTextView: TextView? = null
    private var bankUrl: String? = null
    private var bankPhone: String? = null
    private var cardBin = 0
    val tag = "MyLog"
    val url = "https://lookup.binlist.net/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plain)


        plainTextView = findViewById(R.id.plainText)
        bankUrView = findViewById(R.id.bankUrText)
        bankPhoneView = findViewById(R.id.bankPhoneText)
        Log.d(tag, "--Info Activity onCreate--")
        val intent = intent
        cardBin = intent.getIntExtra("cardBIN", cardBin)
        Log.d(tag, " get card BIN from intent: $cardBin")

        //stub
        //cardBin = 45717360;

        JsonTask().execute()
    }

    private inner class JsonTask : AsyncTask<String?, String?, String?>() {

        override fun doInBackground(vararg p0: String?): String? {
            Log.d(tag, "---doInBackground---")

            val stringFromWeb = getStringFromUrl(cardBin, url )
            Log.d(tag, "---stringFromWeb--- $stringFromWeb")

            return parseJsonToString(stringFromWeb)
       }

        override fun onPostExecute(result: String?) {
            Log.d(tag, "---onPostExecute---")
            plainTextView!!.text = result
            bankUrView!!.text = bankUrl
            bankPhoneView!!.text = bankPhone
        }

    }

    private fun parseJsonToString(data: String?): String {
        Log.d(tag, "---parseJsonToString---")
        if (data == null){
            return "Data not available"
        }
        var result = ""
        try {
            val g = Gson()
            val entity = g.fromJson(data, Entity::class.java)
            Log.d("-----> ENTITY", entity.toString())
            Log.d("-----> ", entity.number.toString())
            Log.d("-----> ", entity.scheme.toString())
            Log.d("-----> ", entity.type.toString())
            Log.d("-----> ", entity.brand.toString())
            Log.d("-----> ", entity.prepaid.toString())
            Log.d("-----> ", entity.bank.toString())
            Log.d("-----> ", entity.country.toString())
            result = """CARD INFO: 
${entity.number}
 SCHEME / NETWORK: ${entity.scheme}
TYPE: ${entity.type}
BRAND: ${entity.brand}
PREPAID: ${entity.prepaid}
${entity.country}
${entity.bank}"""
            bankUrl = entity.bank?.url
            bankPhone = entity.bank?.phone
        } catch (e: Exception) {
            Log.i(tag, "-----------------Error parsing data-----------------" + e.message)
            Toast.makeText(this@PlainActivity, "Failed to load data", Toast.LENGTH_LONG).show()
        }
        return result
    }

    private fun getStringFromUrl(cardBin: Int, url : String): String? {
        try {
            Log.d(tag, "---getStringFromUrl---")
            var result = "No data found"
            val stringFromWeb = URL(url + cardBin)
            Log.d(tag,"stringFromWeb $stringFromWeb")
            result = stringFromWeb.readText()
            Log.d(tag, "apiResponse: -> $result")
            Log.d(tag, "result: -> $result")
            return result
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
        }
        return null

    }

}