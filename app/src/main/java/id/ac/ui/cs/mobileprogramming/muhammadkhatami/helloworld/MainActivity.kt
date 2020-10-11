package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.doraemon_list_fragment, ItemDoraemonFragment()).commit()
    }

    override fun onBackPressed() {
        if(supportFragmentManager.findFragmentById(R.id.doraemon_list_fragment) is DoraemonItemDetail){
            supportFragmentManager.beginTransaction().replace(R.id.doraemon_list_fragment, ItemDoraemonFragment()).commit()
        } else{
            super.onBackPressed()
        }
    }
}