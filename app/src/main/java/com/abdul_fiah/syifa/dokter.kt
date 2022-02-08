package com.abdul_fiah.syifa

import android.app.Activity
import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdul_fiah.syifa.databinding.ActivityDokterBinding

class dokter : AppCompatActivity() {

    private lateinit var binding: ActivityDokterBinding
    private lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDokterBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_dokter)
        setContentView(binding.root)

//        MEMBUAT DATA DOKTER DALAM ARRAY
        val imageId = intArrayOf(
            R.drawable.i,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
            R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.a
        )

        val name = arrayOf(

            "dr. Shui Shine Sp.A",
            "dr. Alfiah Sp.B",
            "dr. Abil Sp.An",
            "dr. Syukra Sp.B.Onk",
            "dr. Afifah Sp.BA",
            "dr. Yoga Sp.BO",
            "dr. Sella Sp.BP",
            "dr. Ichsan Sp.F",
            "dr. Latifah Sp.BS",

        )

        val lastMessage = arrayOf(

            "dr. Sp Anak",
            "dr. Sp Bedah Umum",
            "dr. Sp Anestesi",
            "dr. Sp Onkologi",
            "dr. Sp Bedah Anak",
            "dr. Sp Bedah Ortopedi",
            "dr. Sp Bedah Plastik",
            "dr. Sp Forensik",
            "dr. Sp Bedah Sarah",

        )

        val lastmsgTime = arrayOf(

            "8AM-12AM",
            "8AM-1PM",
            "8AM-3PM",
            "8AM-2PM",
            "8AM-3PM",
            "8AM-4PM",
            "8AM-5PM",
            "8AM-3PM",
            "8AM-2PM",

        )

        val phoneNo = arrayOf(

            "081280647611",
            "081280647612",
            "081280647613",
            "081280647614",
            "081280647615",
            "081280647616",
            "081280647617",
            "081280647618",
            "081280647619",

        )

        val jabatan = arrayOf(

            "Senin - Jum'at",
            "Senin - Kamis",
            "Selasa - Rabu",
            "Senin - Selasa",
            "Kamis - Jumat",
            "Sabtu - Minggu",
            "Jum'at",
            "Rabu",
            "Senin - Sabtu",


        )

        userArrayList = ArrayList()

        for (i in name.indices){
            val user = User(name[i],lastMessage[i],lastmsgTime[i],phoneNo[i],jabatan[i],imageId[i])
            userArrayList.add(user)
        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this,userArrayList)
        binding.listview.setOnItemClickListener{parent,view,position,id ->

            val name = name[position]
            val phone = phoneNo[position]
            val jabatan = jabatan[position]
            val imageId = imageId[position]

            val i = Intent(this,UserActivtiy::class.java)
            i.putExtra("name",name)
            i.putExtra("phone",phone)
            i.putExtra("jabatan",jabatan)
            i.putExtra("imageId",imageId)
            startActivity(i)


        }



    }
}