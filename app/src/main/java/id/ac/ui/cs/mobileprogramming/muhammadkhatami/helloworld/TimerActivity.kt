package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld

import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_timer.*
import java.lang.Thread.sleep


class TimerActivity : AppCompatActivity() {

    private var continueTicking = false
    private var countDown = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        val buttonStartTimer: Button = findViewById(R.id.startTimerButton)
        buttonStartTimer.setOnClickListener{
            if (continueTicking) {
                pauseTimer()
            } else {
                startTimer()
            }
        }
        val buttonResetTimer: Button = findViewById(R.id.resetTimerButton)
        buttonResetTimer.setOnClickListener{
            resetTimer()
        }
        val buttonPlusCount: Button = findViewById(R.id.plusButton)
        buttonPlusCount.setOnClickListener{
            plusCount()
        }
        val buttonMinusCount: Button = findViewById(R.id.minusButton)
        buttonMinusCount.setOnClickListener{
            minusCount()
        }
    }

    private fun resetTimer() {
        countDown = 20
        continueTicking = false

        val startTimerButton : Button = findViewById<Button>(R.id.startTimerButton)
        startTimerButton.text = "Start"

        val timerText : TextView = findViewById<TextView>(R.id.timerText)
        timerText.text = "${countDown.toString()}"
    }

    private fun startTimer() {

        val startTimerButton : Button = findViewById<Button>(R.id.startTimerButton)
        val buttonPlusCount: Button = findViewById(R.id.plusButton)
        val buttonMinusCount: Button = findViewById(R.id.minusButton)

        buttonPlusCount.isEnabled = false
        buttonMinusCount.isEnabled = false
        continueTicking = true

        startTimerButton.text = "Pause"

        Thread(Runnable {
            while (countDown > 0 && continueTicking) {
                sleep(1000)
                countDown -= 1
                this@TimerActivity.runOnUiThread(java.lang.Runnable {
                    this.timerText.text = "${countDown.toString()}"
                })
            }
            if (countDown == 0) {
                this@TimerActivity.runOnUiThread(java.lang.Runnable {
                    this.timerText.text = "Timeout"
                })
            }
        }).start()
    }

    private fun pauseTimer() {
        continueTicking = false

        val startTimerButton : Button = findViewById<Button>(R.id.startTimerButton)
        startTimerButton.text = "Start"

        val buttonPlusCount: Button = findViewById(R.id.plusButton)
        val buttonMinusCount: Button = findViewById(R.id.minusButton)

        buttonPlusCount.isEnabled = true
        buttonMinusCount.isEnabled = true
    }

    private fun plusCount() {
        countDown++
        val timerText : TextView = findViewById<TextView>(R.id.timerText)
        timerText.text = "${countDown.toString()}"
    }

    private fun minusCount() {
        countDown--
        val timerText : TextView = findViewById<TextView>(R.id.timerText)
        timerText.text = "${countDown.toString()}"
    }
}