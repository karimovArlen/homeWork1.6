package kg.geectech.lesoon1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.geectech.lesoon1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultLauncher()
        setUpListener()
    }

    private fun resultLauncher() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.etMA1.setText(result.data?.getStringExtra(EXTRA_MASSAGE))
                }
            }
    }

    companion object {
        const val EXTRA_MASSAGE = "sun"
    }

    private fun setUpListener() {
        binding.btMA1.setOnClickListener {
            if (binding.etMA1.text.toString() == "") {
                Toast.makeText(this, "EditText не может быть пустым", Toast.LENGTH_SHORT)
                    .show()
            } else openActivity()

        }
    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(EXTRA_MASSAGE, binding.etMA1.text.toString())
        }
        resultLauncher.launch(intent)
    }

}
