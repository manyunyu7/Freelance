package com.eva.dikejar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eva.dikejar.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        actionBar?.hide()
        supportActionBar?.hide()

        GlobalScope.launch {
            delay(1500)
            withContext(Dispatchers.IO) {
                finish()
                startActivity(Intent(this@MainActivity, NavigationControllerActivity::class.java))
            }
        }
    }
}