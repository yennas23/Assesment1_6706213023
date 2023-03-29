package org.d3if3023.temperatureconvert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.core.view.isVisible
import org.d3if3023.temperatureconvert.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val df = DecimalFormat("#.##")//Decimal formatter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConvert.setOnClickListener { convertTemperature() }
    }
    
    private fun convertTemperature() {
        // inisialiasi variabel dengan memamggil inputan dari inpTemperature
        val suhu = binding.inpTemperature.text.toString()
        var doubleInput = suhu.toDouble()

        // melakukan pengecekan inputan kalau kosong (sanity check)
        if (TextUtils.isEmpty(suhu)) {
            Toast.makeText(this, R.string.suhu_invalid, Toast.LENGTH_LONG).show()
        }

        // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
        binding.Konversi.isVisible = true
        binding.hasilFahrenheit.isVisible = true
        binding.hasilKelvin.isVisible = true
        binding.hasilReamur.isVisible = true

        // rumus mengubah suhu
        val kelvin = df.format(doubleInput + 273.15)
        val fahrenheit = df.format((doubleInput * 9/5)+32)
        val reamur = df.format(doubleInput * 4/5)
        binding.Konversi.text = getString(R.string.konversi_intro)
        binding.hasilFahrenheit.text = getString(R.string.fah)+ " " + fahrenheit + " " + getString(R.string.fahrenheit)
        binding.hasilKelvin.text = getString(R.string.kel) + " " + kelvin + " " + getString(R.string.kelvin)
        binding.hasilReamur.text = getString(R.string.rea) + " " + reamur + " " + getString(R.string.reamur)

    }
}
