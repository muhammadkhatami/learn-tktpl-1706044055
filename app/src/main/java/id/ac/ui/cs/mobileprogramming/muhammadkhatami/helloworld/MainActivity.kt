package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to button
        val btn_click_me: Button = findViewById(R.id.clickMe)
        btn_click_me.setOnClickListener{
            changeTheme()
        }

        val goToTimerButton: Button = findViewById(R.id.goToTimer)
        goToTimerButton.setOnClickListener{
            navigateToTimerActivity()
        }
    }

    private fun changeTheme() {
        var changed : Int = 1;
        
        val btn_click_me = findViewById(R.id.clickMe) as Button
        val mainText = findViewById(R.id.mainText) as TextView
        var constraintLayout : ConstraintLayout = findViewById(R.id.mainLayout)
        var secondText = findViewById(R.id.secondText) as TextView

        btn_click_me.setOnClickListener {
            if (changed == 1) {
                changed = 2
                secondText.setTextColor(ContextCompat.getColor(this, R.color.colorDarkBlue))
                constraintLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.colorSilver
                    )
                )
                btn_click_me.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDark))
                btn_click_me.setTextColor(ContextCompat.getColor(this, R.color.colorSilver))
            } else {
                changed = 1
                secondText.setTextColor(ContextCompat.getColor(this, R.color.colorSilver))
                constraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDark))
                btn_click_me.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSilver))
                btn_click_me.setTextColor(ContextCompat.getColor(this, R.color.colorDarkBlue))
            }
        }
    }

    private fun navigateToTimerActivity(){
        val intent = Intent(this, TimerActivity::class.java).apply {
        }
        startActivity(intent)
    }

    private var exit = false
    override fun onBackPressed() {
        if (exit) {
            finish()
        } else {
            Toast.makeText(this, "Press again to exit",
                Toast.LENGTH_SHORT).show()
            exit = true
            object : CountDownTimer(1000, 500) {
                override fun onTick(l: Long) {}
                override fun onFinish() {
                    exit = false
                }
            }.start()
        }
    }
}