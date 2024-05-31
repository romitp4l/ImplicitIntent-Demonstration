package com.example.implicitintent_demonstration

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val TAG = "MainActivity"
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
  //  }
//

            val buttonMail : Button = findViewById(R.id.mailToButton)
            val buttonPhone : Button = findViewById(R.id.callToButton)
            val buttonBrowse : Button = findViewById(R.id.browserButton)
            var editText : EditText = findViewById(R.id.editTextDestination)


        buttonMail.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Mail", Toast.LENGTH_SHORT).show()
            Log.d(TAG,"Mail Button")
            val email = editText.text.toString()
            val i = Intent()
            i.action = Intent.ACTION_SENDTO
            i.data = Uri.parse("mailto:$email")
            startActivity(i)
        })

            buttonBrowse.setOnClickListener(View.OnClickListener {
                Toast.makeText(this, "Browse", Toast.LENGTH_SHORT).show()
                Log.d(TAG,"Browse Button")

                val address = editText.text.toString()
                val i = Intent()
                i.action = Intent.ACTION_VIEW
                i.data = Uri.parse("https://$address")
                startActivity(i)

            })



        buttonPhone.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show()
            Log.d(TAG,"Call Button")

            val number = editText.text.toString()
            val i = Intent()
            i.action = Intent.ACTION_DIAL
            i.data = Uri.parse("tel:$number")
            startActivity(i)

        })



        editText.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "EditText", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "EditText")


        })






        val buttonForAnotherActivity : Button = findViewById(R.id.buttonForAnotherActivity)
        buttonForAnotherActivity.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Button for another activity", Toast.LENGTH_SHORT).show()
            Log.d(TAG,"Button for another activity")
            val name = editText.text.toString()

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        })



    }
}