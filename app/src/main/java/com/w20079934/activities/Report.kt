package com.w20079934.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.w20079934.adapters.DonationAdapter
import com.w20079934.main.DonationApp
import com.w20079934.main.R
import kotlinx.android.synthetic.main.activity_report.*

class Report : AppCompatActivity() {

    lateinit var app: DonationApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        app = this.application as DonationApp
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.adapter = DonationAdapter(app.donationsStore.findAll())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_report, menu)
        return true
    }
}