package com.example.mytest.underCounter

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.mytest.databinding.ActivityUnderCounterBinding

class UnderCounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUnderCounterBinding
    private var isStop: Boolean = false
    private var startMls: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnderCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonStartTimer.setOnClickListener {
            createTimer(startMls, 1).start()
            it.isEnabled = false
            binding.buttonStopTimer.isEnabled = true
            isStop = false

        }

        binding.buttonStopTimer.setOnClickListener {
            it.isEnabled = false
            isStop = true
            binding.buttonStartTimer.isEnabled = true
        }

    }

    private fun createTimer(mls: Long, step: Long): CountDownTimer {

        return object : CountDownTimer(mls, step) {
            override fun onTick(mls: Long) {

                if (isStop) {
                    binding.timerView.text = mls.toString()
                    startMls = mls
                    cancel()
                    isStop = true
                } else {
                    binding.timerView.text = mls.toString()

                }
            }

            override fun onFinish() {
                binding.timerView.text = "Finish"
                binding.buttonStopTimer.isEnabled = false
                binding.buttonStartTimer.isEnabled = true
                isStop = false
                startMls = 5000
            }
        }


    }
}