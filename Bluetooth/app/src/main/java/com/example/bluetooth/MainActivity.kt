package com.example.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var  BA: BluetoothAdapter
    lateinit var pairedDevices: Set<BluetoothDevice>
    lateinit var lv : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BA = BluetoothAdapter.getDefaultAdapter()
        lv = listView

    }


    // turns on bluetooth
    fun on(v: View?) {
        if (!BA.isEnabled()) {
            val turnOn = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(turnOn, 0)
            Toast.makeText(applicationContext, "Turned on", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(applicationContext, "Already on", Toast.LENGTH_LONG).show()
        }
    }

    // turns off bluetooth
    fun off(v: View?) {
        BA.disable()
        Toast.makeText(applicationContext, "Turned off", Toast.LENGTH_LONG).show()
    }

    // turns on the ability to find devices
    fun visible(v: View?) {
        val getVisible = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE)
        startActivityForResult(getVisible, 0)
    }


    //
    fun list(v: View?) {
        pairedDevices = BA.getBondedDevices()
        val list = ArrayList<Any>()
        for (bt in pairedDevices) list.add(bt.name)
        Toast.makeText(applicationContext, "Showing Paired Devices", Toast.LENGTH_SHORT).show()
        val adapter: ArrayAdapter<*> = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        lv.setAdapter(adapter)
    }

}