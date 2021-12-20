package com.armutyus.bluebird

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.armutyus.bluebird.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun easyButton(view: View) {
        val intentFromMain = Intent(this@MainActivity,GameActivity::class.java)
        intentFromMain.putExtra("mode","easy")
        startActivity(intentFromMain)

    }

    fun hardButton(view: View) {
        val intentFromMain = Intent(this@MainActivity,GameActivity::class.java)
        intentFromMain.putExtra("mode","hard")
        startActivity(intentFromMain)

    }

    fun legendButton(view: View) {
        val intentFromMain = Intent(this@MainActivity,GameActivity::class.java)
        intentFromMain.putExtra("mode","legend")
        startActivity(intentFromMain)

    }
}