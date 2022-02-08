package com.abdul_fiah.syifa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdul_fiah.syifa.databinding.ActivityDashboardBinding

class dashboard : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.maps.setOnClickListener {
//            startActivity(Intent(this, LokasiActivity::class.java))
//        }
        binding.btnBantuan.setOnClickListener {
            startActivity(Intent(this, bantuan::class.java))
        }
//        binding.btnJadwal.setOnClickListener {
//            startActivity(Intent(this, jadwal::class.java))
//        }
        binding.btnKamar.setOnClickListener {
            startActivity(Intent(this, kamar::class.java))
        }
        binding.btnDokter.setOnClickListener {
            startActivity(Intent(this, dokter::class.java))
        }
        binding.btnDaftar.setOnClickListener {
            startActivity(Intent(this, daftar::class.java))
        }
    }
}