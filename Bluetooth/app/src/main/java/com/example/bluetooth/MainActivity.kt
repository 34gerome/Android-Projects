package com.example.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        //create bluuetoothAdapter OBJECT
        var bluetoothAdapter =  BluetoothAdapter.getDefaultAdapter()

        // turns on/ enables bluetooth
        val turnOn = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        startActivityForResult(turnOn, 0)

        // get the list of bonded devices through bluetooth adapter
        var pariedDevices: Set<BluetoothDevice>
        pariedDevices = bluetoothAdapter.bondedDevices

        //

    }
}