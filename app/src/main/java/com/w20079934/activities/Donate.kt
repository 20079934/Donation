package com.w20079934.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.w20079934.main.DonationApp
import com.w20079934.main.R
import com.w20079934.models.DonationModel
import kotlinx.android.synthetic.main.activity_donate.*

class Donate : AppCompatActivity() {
    lateinit var app: DonationApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)
        app = this.application as DonationApp


        progressBar.max = 10000

        amountPicker.minValue = 1
        amountPicker.maxValue = 1000

        amountPicker.setOnValueChangedListener { _, _, newVal ->
            //Display the newly selected number to paymentAmount
            paymentAmount.setText("$newVal")
        }

        var totalDonated = 0

        donateButton.setOnClickListener {
            val amount = if (paymentAmount.text.isNotEmpty())
                paymentAmount.text.toString().toInt() else amountPicker.value
            if(totalDonated >= progressBar.max)
                Toast.makeText(this,"Donate Amount Exceeded!",Toast.LENGTH_LONG).show()
            else {
                val paymentmethod = if(paymentMethod.checkedRadioButtonId == R.id.Direct) "Direct" else "Paypal"
                totalDonated += amount
                totalSoFar.text = "$$totalDonated"
                progressBar.progress = totalDonated
                app.donationsStore.create(DonationModel(paymentmethod = paymentmethod,amount = amount))
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_donate, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_report -> { startActivity(Intent(this, Report::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}