package com.example.mypilgubdki

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mypilgubdki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Inisialisasi adapter dengan data dummy
        val paslonAdapter = PaslonAdapter(generateDataDummy()) { paslon ->
            Toast.makeText(this@MainActivity, "Paslon 1 ${paslon.namaCagub} dan ${paslon.namaCawagub}", Toast.LENGTH_SHORT).show()
        }

        with(binding) {
            rvPaslonPilgub.apply {
                adapter = paslonAdapter
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }
    }

    // Fungsi untuk menghasilkan data dummy
    private fun generateDataDummy(): List<Paslon> {
        // Daftar asli dengan 3 paslon
        val listPaslon = listOf(
            Paslon(
                imgCagub = R.drawable.paslon_kamil,
                namaCagub = "Ridwan Kamil",
                partaiPendukungCagub = "Koalisi KIM+",
                imgCawagub = R.drawable.paslon_suswono,
                namaCawagub = "Suswono",
                partaiPendukungCawagub = "Koalisi KIM+"
            ),
            Paslon(
                imgCagub = R.drawable.paslon_darmachan,
                namaCagub = "Dharma Pongrekun",
                partaiPendukungCagub = "Independen",
                imgCawagub = R.drawable.paslon_kun,
                namaCawagub = "Kun Wardana",
                partaiPendukungCawagub = "Independen"
            ),
            Paslon(
                imgCagub = R.drawable.paslon_anung,
                namaCagub = "Pramono Anung",
                partaiPendukungCagub = "PDIP, Partai Hati Nurani, Partai Ummat",
                imgCawagub = R.drawable.paslon_karno,
                namaCawagub = "Rano Karno",
                partaiPendukungCawagub = "PDIP, Partai Hati Nurani, Partai Ummat"
            )
        )
        return listPaslon;
    }
}
