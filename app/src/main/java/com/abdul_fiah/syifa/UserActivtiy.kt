package com.abdul_fiah.syifa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdul_fiah.syifa.databinding.ActivityUserBinding

class UserActivtiy : AppCompatActivity() {

    private lateinit var binding : ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_user)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val jabatan = intent.getStringExtra("jabatan")
        val imageId = intent.getIntExtra("imageId",R.drawable.a)

        binding.nameProfile.text = name
        binding.phoneProfile.text = phone
        binding.jabatanProfile.text = jabatan
        binding.profileImage.setImageResource(imageId)

    }
}