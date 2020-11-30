package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var wifiManager: WifiManager
    private lateinit var wifiRecyclerViewAdapter: WifiRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        permissionCheck()
        wifiManager = this.applicationContext?.getSystemService(Context.WIFI_SERVICE) as WifiManager
        scanWifi()

        wifi_recycler_view.layoutManager = LinearLayoutManager(this)
        wifiRecyclerViewAdapter = WifiRecyclerViewAdapter(emptyList())
        wifi_recycler_view.adapter = wifiRecyclerViewAdapter
    }

    private fun permissionCheck() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) ==  PackageManager.PERMISSION_GRANTED) {
            //
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_WIFI_STATE,
                    Manifest.permission.CHANGE_WIFI_STATE
                ), 101
            )
        }
    }

    private fun scanWifi() {
        val wifiScanReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
                if (success) {
                    scanSuccess()
                } else {
                    scanFailure()
                }
            }
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        this.getApplicationContext().registerReceiver(wifiScanReceiver, intentFilter)

        val success = wifiManager.startScan()
        if (!success) {
            scanFailure()
        }
    }

    private fun scanSuccess() {
        val results = wifiManager.scanResults
        Log.d("results", results.toString())
        generateWifiAdapterList(results)
    }

    private fun scanFailure() {
        Log.d("Fail", "FailFailFailFailFail")
    }

    private fun generateWifiAdapterList(results: List<ScanResult>) {
        val wifiResultList =  mutableListOf<String>()
        for (res in results) {
            wifiResultList.add(res.SSID)
        }
        wifiRecyclerViewAdapter = WifiRecyclerViewAdapter(wifiResultList)
        wifi_recycler_view.adapter = wifiRecyclerViewAdapter
        Log.d("result", wifiResultList.toString())

        val thread = Thread {
            try {
                sendRequest(wifiResultList.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        thread.start()
    }

    private fun sendRequest(wifiResultList: String) {
        val url = URL("https://2932cff3781bc1049345f803efb4774b.m.pipedream.net")
        val con = url.openConnection() as HttpURLConnection
        con.requestMethod = "POST"
        con.setRequestProperty("Content-Type", "application/json; utf-8")
        con.setRequestProperty("Accept", "application/json")
        con.doOutput = true
        val jsonInputString: String = "{\"data\":$wifiResultList}"
        con.outputStream.use { os ->
            val input = jsonInputString.toByteArray(charset("utf-8"))
            os.write(input, 0, input.size)
        }
        BufferedReader(
            InputStreamReader(con.inputStream, "utf-8")
        ).use({ br ->
            val response = java.lang.StringBuilder()
            var responseLine: String? = null
            while (br.readLine().also({ responseLine = it }) != null) {
                response.append(responseLine!!.trim { it <= ' ' })
            }
            println(response.toString())
        })

        this@MainActivity.runOnUiThread(java.lang.Runnable {
            Toast.makeText(getApplicationContext(),"Wifi Sent!",Toast.LENGTH_SHORT).show()
        })
    }
}