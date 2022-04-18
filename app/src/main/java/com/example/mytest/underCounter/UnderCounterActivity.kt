package com.example.mytest.underCounter

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.mytest.databinding.ActivityUnderCounterBinding

class UnderCounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUnderCounterBinding
    private var isStop: Boolean? = null
    private var startMls: Long? = null
    private var showMls: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnderCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStateActivity()

        if (savedInstanceState != null) {
            showMls = savedInstanceState.getLong("time")
            binding.timerView.text = showMls.toString()
            startMls = savedInstanceState.getLong("time")
        }

        binding.buttonStartTimer.setOnClickListener {
            createTimer(startMls!!, 1).start()
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


                // if timer stoped save mls and coled cancel function

                if (isStop!!) {
                    showMls = mls
                    binding.timerView.text = showMls.toString()
                    startMls = mls
                    cancel()
                    isStop = true
                } else {
                    showMls = mls
                    binding.timerView.text = showMls.toString()

                }
            }

            override fun onFinish() {
                binding.timerView.text = "Finish"
                setStateActivity()
            }
        }


    }

    // save state activity
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("time", showMls!!)
    }

    private fun setStateActivity() {
        binding.buttonStopTimer.isEnabled = false
        binding.buttonStartTimer.isEnabled = true
        isStop = false
        startMls = 5000
    }
}