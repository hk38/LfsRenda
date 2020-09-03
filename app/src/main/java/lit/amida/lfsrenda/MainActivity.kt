package lit.amida.lfsrenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCount.setOnClickListener {
            count++
            textCount.text = count.toString()
        }

        buttonCount.isClickable = false
        buttonCount.setBackgroundResource(R.drawable.round_grayout)

        buttonStart.setOnClickListener {
            count = 0
            textCount.text = count.toString()
            buttonCount.isClickable = true
            buttonCount.setBackgroundResource(R.drawable.round)

            val timer = CountDown(10000, 1000)
            timer.start()
            buttonStart.visibility = View.INVISIBLE
        }


    }

    inner class CountDown(millisInFuture: Long, countDownInterval: Long): CountDownTimer(millisInFuture, countDownInterval) {
        override fun onFinish() {
            buttonCount.isClickable = false
            buttonCount.setBackgroundResource(R.drawable.round_grayout)
            buttonStart.visibility = View.VISIBLE
        }

        override fun onTick(p0: Long) {
            textTime.text = (p0/1000).toInt().toString()
        }


    }
}