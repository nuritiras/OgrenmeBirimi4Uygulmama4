package tr.com.nuritiras.ogrenmebirimi4uygulmama4

import android.os.Bundle
import android.view.View
import android.widget.Switch
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val konumServisi = findViewById<Switch>(R.id.switch_KonumServisi)
        val konumAl = findViewById<Switch>(R.id.switch_KonumAl)
        val konumGonder = findViewById<Switch>(R.id.switch_KonumGonder)

        // İlk açıldığında kontrol edilecekler
        if(konumServisi.isChecked){
            konumAl.visibility = View.VISIBLE
            konumGonder.visibility = View.VISIBLE
        }
        else
        {
            konumAl.visibility = View.GONE
            konumGonder.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        val konumServisi = findViewById<Switch>(R.id.switch_KonumServisi)
        val konumAl = findViewById<Switch>(R.id.switch_KonumAl)
        val konumGonder = findViewById<Switch>(R.id.switch_KonumGonder)
        
        konumServisi.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                konumAl.visibility = View.VISIBLE
                konumGonder.visibility = View.VISIBLE
            } else {
                konumAl.visibility = View.GONE
                konumGonder.visibility = View.GONE
            }
        }
    }

    fun onClickOnayla(view: View) {
        val konumServisi = findViewById<Switch>(R.id.switch_KonumServisi)
        val konumAl = findViewById<Switch>(R.id.switch_KonumAl)
        val konumGonder = findViewById<Switch>(R.id.switch_KonumGonder)

        if(konumServisi.isChecked) {
            if(konumAl.isChecked && konumGonder.isChecked) {
                Toast.makeText(this, "Konum Al ve Konum Gönder Açık", Toast.LENGTH_SHORT).show()
            }
            if(!konumAl.isChecked && konumGonder.isChecked) {
                Toast.makeText(this, "Konum Al Kapalı, Konum Gönder Açık", Toast.LENGTH_SHORT).show()
            }
            if(konumAl.isChecked && !konumGonder.isChecked) {
                Toast.makeText(this, "Konum Al Açık, Konum Gönder Kapalı", Toast.LENGTH_SHORT).show()
            }
            if(!konumAl.isChecked && !konumGonder.isChecked) {
                Toast.makeText(this, "Konum Al ve Konum Gönder Kapalı", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(this, "Konum Servisleri Kapalı", Toast.LENGTH_SHORT).show()
        }
    }
}