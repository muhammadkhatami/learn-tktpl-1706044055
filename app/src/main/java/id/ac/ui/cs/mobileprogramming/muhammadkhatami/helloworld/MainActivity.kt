package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private external fun processNumber(inputNumber: Int) : String

    companion object {
        // Used to load the 'jni' library on application startup.
        init {
            System.loadLibrary("jni")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNumber: EditText = findViewById(R.id.input_number)
        val buttonSubmitInt: Button = findViewById(R.id.submit_number)
        val textResult: TextView = findViewById(R.id.text_result)
        buttonSubmitInt.setOnClickListener{
            val resultNumber = processNumber(inputNumber.text.toString().toInt())
            textResult.text = resultNumber
        }
    }
}