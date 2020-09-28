package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to button
        val btn_click_me = findViewById(R.id.clickMe) as Button
        btn_click_me.setOnClickListener{
            changeTheme()
        }
    }

    fun changeTheme() {
        var changed : Int = 1;

        val btn_click_me = findViewById(R.id.clickMe) as Button
        var constraintLayout : ConstraintLayout = findViewById(R.id.mainLayout)
        var secondText = findViewById(R.id.secondText) as TextView
        var themeText = findViewById(R.id.themeName) as TextView

        btn_click_me.setOnClickListener {
            if (changed == 1) {
                changed = 2
                secondText.setTextColor(ContextCompat.getColor(this, R.color.colorDarkBlue))
                constraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSilver))
                btn_click_me.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDark))
                btn_click_me.setTextColor(ContextCompat.getColor(this, R.color.colorSilver))
                themeText.setText("Light")
                themeText.setTextColor(ContextCompat.getColor(this, R.color.colorDarkBlue))
            } else {
                changed = 1
                secondText.setTextColor(ContextCompat.getColor(this, R.color.colorSilver))
                constraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDark))
                btn_click_me.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSilver))
                btn_click_me.setTextColor(ContextCompat.getColor(this, R.color.colorDarkBlue))
                themeText.setText("Dark")
                themeText.setTextColor(ContextCompat.getColor(this, R.color.colorSilver))
            }
        }
        themeChanged()
    }

    fun themeChanged() : String {
        return "theme changed"
    }
}