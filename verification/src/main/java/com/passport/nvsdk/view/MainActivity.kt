package com.passport.nvsdk.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.passport.nvsdk.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, GojekOtpFragment(), null)
        transaction.commit()
    }
}