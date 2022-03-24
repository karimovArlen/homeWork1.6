package kg.geectech.lesoon1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.geectech.lesoon1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private val binding: ActivityMain2Binding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setUpListener()

    }

    private fun setUpListener() {
        binding.etMA2.setText(intent.getStringExtra(MainActivity.EXTRA_MASSAGE))
        binding.btMA2.setOnClickListener {
            if (binding.etMA2.text.toString() == "") {
                Toast.makeText(this, "EditText не может быть пустым", Toast.LENGTH_SHORT)
                    .show()
            } else openActivity()
        }

    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(MainActivity.EXTRA_MASSAGE, binding.etMA2.text.toString())
        }
        setResult(Activity.RESULT_OK, intent)
        finish()

    }
}