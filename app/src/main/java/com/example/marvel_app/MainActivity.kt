package com.example.marvel_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvel_app.view.MainFragment
import dagger.hilt.android.AndroidEntryPoint
import java.math.BigInteger
import java.security.MessageDigest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val currentTimestamp = System.currentTimeMillis()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commitNow()
        }

//        fun String.md5(): String {
//            val md = MessageDigest.getInstance("MD5")
//            return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
//        }
        println(currentTimestamp)
    }
}