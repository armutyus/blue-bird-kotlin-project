package com.armutyus.bluebird

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.armutyus.bluebird.databinding.ActivityGameBinding
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*
import kotlin.collections.ArrayList

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    var imageArray = ArrayList<ImageView>()
    var score = 0
    var handler = Handler(Looper.getMainLooper())
    var runnable = Runnable {  }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        imageArray.add(imageView)
        imageArray.add(imageView1)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)

        hideImages()

        object: CountDownTimer(20000,1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timeText.text = "Time: " + millisUntilFinished/1000
            }

            override fun onFinish() {
                binding.timeText.text = "Finish!"
                handler.removeCallbacks(runnable)

                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val alert = AlertDialog.Builder(this@GameActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart the Game?")
                alert.setPositiveButton("YES") {dialog, which ->
                    val intentAlert = intent
                    finish()
                    startActivity(intentAlert)
                }

                alert.setNegativeButton("NO") {dialog, which ->
                    Toast.makeText(this@GameActivity,"Game Over",Toast.LENGTH_LONG).show()
                    finish()
                    val intentToMain = Intent(this@GameActivity, MainActivity::class.java)
                    startActivity(intentToMain)
                }

                alert.show()


            }

        }.start()

    }

    fun hideImages() {

        val name = intent?.getStringExtra("mode")

        runnable = object: Runnable {
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = Random()
                val randomIndex = random.nextInt(9)
                imageArray[randomIndex].visibility = View.VISIBLE

                if(name == "easy") {

                    handler.postDelayed(runnable,750)

                } else if (name == "hard") {

                    handler.postDelayed(runnable,500)

                } else if (name == "legend") {

                    handler.postDelayed(runnable,250)

                }

            }
        }
        handler.post(runnable)

    }



    fun increaseScore(view: View) {

        score += 1
        scoreText.text = "Score: $score"

    }
}