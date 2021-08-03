package com.fariz.angklung

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fariz.angklung.databinding.ActivityAngklungBinding


class AngklungActivity : AppCompatActivity() {

    val binding by lazy { ActivityAngklungBinding.inflate(layoutInflater) }

    lateinit var mediaPlayer1: LoopMediaPlayer
    lateinit var mediaPlayer2: LoopMediaPlayer
    lateinit var mediaPlayer3: LoopMediaPlayer
    lateinit var mediaPlayer4: LoopMediaPlayer
    lateinit var mediaPlayer5: LoopMediaPlayer
    lateinit var mediaPlayer6: LoopMediaPlayer
    lateinit var mediaPlayer7: LoopMediaPlayer
    lateinit var mediaPlayer8: LoopMediaPlayer
    lateinit var mediaPlayer9: LoopMediaPlayer
    lateinit var mediaPlayer10: LoopMediaPlayer
    lateinit var mediaPlayer11: LoopMediaPlayer
    lateinit var mediaPlayer12: LoopMediaPlayer
    lateinit var mediaPlayer13: LoopMediaPlayer
    lateinit var mediaPlayer14: LoopMediaPlayer

    lateinit var stopedMp: LoopMediaPlayer

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        actionBar?.hide()
        supportActionBar?.hide()

        binding.at1.setOnTouchListener { _, event ->
            angklungTouch(1, event)
            true
        }

        binding.at2.setOnTouchListener { _, event ->
            angklungTouch(2, event)
            true
        }

        binding.at3.setOnTouchListener { _, event ->
            angklungTouch(3, event)
            true
        }

        binding.at4.setOnTouchListener { _, event ->
            angklungTouch(4, event)
            true
        }

        binding.at5.setOnTouchListener { _, event ->
            angklungTouch(5, event)
            false
        }

        binding.at6.setOnTouchListener { _, event ->
            angklungTouch(6, event)
            false
        }

        binding.at7.setOnTouchListener { _, event ->
            angklungTouch(7, event)
            false
        }
        binding.at8.setOnTouchListener { _, event ->
            angklungTouch(8, event)
            false
        }
        binding.at9.setOnTouchListener { _, event ->
            angklungTouch(9, event)
            false
        }
        binding.at10.setOnTouchListener { _, event ->
            angklungTouch(10, event)
            false
        }
        binding.at11.setOnTouchListener { _, event ->
            angklungTouch(11, event)
            false
        }
        binding.at12.setOnTouchListener { _, event ->
            angklungTouch(12, event)
            false
        }
        binding.at13.setOnTouchListener { _, event ->
            angklungTouch(13, event)
            false
        }
        binding.at14.setOnTouchListener { _, event ->
            angklungTouch(14, event)
            false
        }



    }

    fun angklungTouch(code: Int, event: MotionEvent) {
        when (event.action) {
            //Berlaku ketika tombol ditekan
            MotionEvent.ACTION_DOWN -> {
                when (code) {
                    1 -> {
                        goyangAngklung(binding.at1)
                        mediaPlayer1 = LoopMediaPlayer.create(this, R.raw.sound1)
                    }
                    2 -> {
                        goyangAngklung(binding.at2)
                        mediaPlayer2 = LoopMediaPlayer.create(this, R.raw.sound2)
                    }
                    3 -> {
                        goyangAngklung(binding.at3)
                        mediaPlayer3 = LoopMediaPlayer.create(this, R.raw.sound3)
                    }
                    4 -> {
                        goyangAngklung(binding.at4)
                        mediaPlayer4 = LoopMediaPlayer.create(this, R.raw.sound4)
                    }
                    5 -> {
                        goyangAngklung(binding.at5)
                        mediaPlayer5 = LoopMediaPlayer.create(this, R.raw.sound5)
                    }
                    6 -> {
                        goyangAngklung(binding.at6)
                        mediaPlayer6 = LoopMediaPlayer.create(this, R.raw.sound6)
                    }
                    7 -> {
                        goyangAngklung(binding.at7)
                        mediaPlayer7 = LoopMediaPlayer.create(this, R.raw.sound7)
                    }
                    8 -> {
                        goyangAngklung(binding.at8)
                        mediaPlayer8 = LoopMediaPlayer.create(this, R.raw.sound8)
                    }
                    9 -> {
                        goyangAngklung(binding.at9)
                        mediaPlayer9 = LoopMediaPlayer.create(this, R.raw.sound9)
                    }
                    10 -> {
                        goyangAngklung(binding.at10)
                        mediaPlayer10 = LoopMediaPlayer.create(this, R.raw.sound10)
                    }
                    11 -> {
                        goyangAngklung(binding.at11)
                        mediaPlayer11 = LoopMediaPlayer.create(this, R.raw.sound11)
                    }
                    12 -> {
                        goyangAngklung(binding.at12)
                        mediaPlayer12 = LoopMediaPlayer.create(this, R.raw.sound12)
                    }
                    13 -> {
                        goyangAngklung(binding.at13)
                        mediaPlayer13 = LoopMediaPlayer.create(this, R.raw.sound13)
                    }
                    14 -> {
                        goyangAngklung(binding.at14)
                        mediaPlayer14 = LoopMediaPlayer.create(this, R.raw.sound14)
                    }

                }
            } //Do Something
            MotionEvent.ACTION_UP -> {
                when (code) {
                    1 -> {
                        stopGoyangAngklung(binding.at1)
                        mediaPlayer1.stopAllSound()
                    }
                    2 -> {
                        stopGoyangAngklung(binding.at2)
                        mediaPlayer2.stopAllSound()
                    }
                    3 -> {
                        stopGoyangAngklung(binding.at3)
                        mediaPlayer3.stopAllSound()
                    }
                    4 -> {
                        stopGoyangAngklung(binding.at4)
                        mediaPlayer4.stopAllSound()
                    }
                    5 -> {
                        stopGoyangAngklung(binding.at5)
                        mediaPlayer5.stopAllSound()
                    }
                    6 -> {
                        stopGoyangAngklung(binding.at6)
                        mediaPlayer6.stopAllSound()
                    }
                    7 -> {
                        stopGoyangAngklung(binding.at7)
                        mediaPlayer7.stopAllSound()
                    }
                    8 -> {
                        stopGoyangAngklung(binding.at8)
                        mediaPlayer8.stopAllSound()
                    }
                    9 -> {
                        stopGoyangAngklung(binding.at9)
                        mediaPlayer9.stopAllSound()
                    }
                    10 -> {
                        stopGoyangAngklung(binding.at10)
                        mediaPlayer10.stopAllSound()
                    }
                    11 -> {
                        stopGoyangAngklung(binding.at11)
                        mediaPlayer11.stopAllSound()
                    }
                    12 -> {
                        stopGoyangAngklung(binding.at12)
                        mediaPlayer12.stopAllSound()
                    }
                    13 -> {
                        stopGoyangAngklung(binding.at13)
                        mediaPlayer13.stopAllSound()
                    }
                    14 -> {
                        stopGoyangAngklung(binding.at14)
                        mediaPlayer14.stopAllSound()
                    }

                }
            }
        }
    }

    private fun goyangAngklung(xml : View){
//        xml.startAnimation(
//            AnimationUtils.loadAnimation(
//                this,
//                R.anim.short_shake
//            )
//        )
    }

    private fun stopGoyangAngklung(xml : View){
//        xml.clearAnimation()
    }


    fun String.showLongToast() {
        Toast.makeText(this@AngklungActivity, this, Toast.LENGTH_LONG).show()
    }
}