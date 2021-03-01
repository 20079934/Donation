package com.w20079934.main

import android.app.Application
import android.util.Log
import com.w20079934.models.DonationMemStore
import com.w20079934.models.DonationStore

class DonationApp : Application() {

    lateinit var donationsStore: DonationStore

    override fun onCreate() {
        super.onCreate()
        donationsStore = DonationMemStore()
        Log.v("Donate","Donation App started")
    }
}