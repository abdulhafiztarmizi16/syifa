package com.abdul_fiah.syifa.fragments.tambah

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.abdul_fiah.syifa.R
import com.abdul_fiah.syifa.model.Pendaftaran
import com.abdul_fiah.syifa.viewmodel.PendaftaranViewModel
import kotlinx.android.synthetic.main.fragment_tambah.*
import kotlinx.android.synthetic.main.fragment_tambah.view.*


class TambahFragment : Fragment() {
    private lateinit var mPendaftaranViewModel: PendaftaranViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tambah, container, false)

        mPendaftaranViewModel = ViewModelProvider(this).get(PendaftaranViewModel::class.java)

        view.btn_add.setOnClickListener{
            masukkanDataKeDatabase()
        }
        return view
    }

    private fun masukkanDataKeDatabase(){
        val antrian = edt_antrian.text.toString()
        val nama = edt_nama.text.toString()
        val umur = edt_umur.text.toString()
        val alamat = edt_alamat.text.toString()
        val namaD = edt_dokter.text.toString()
        val tanggal = edt_tanggal.text.toString()

        if(cekInput(antrian, nama, umur, alamat, namaD, tanggal)){
            val pendaftaran = Pendaftaran(0, antrian, nama, umur, alamat, namaD, tanggal)

            mPendaftaranViewModel.tambahPendaftaran(pendaftaran)
            Toast.makeText(requireContext(), "Data Berhasil ditambahkan", Toast.LENGTH_SHORT)
                .show()

            findNavController().navigate(R.id.action_tambahFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Silahkan isi dulu datanya", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun cekInput(
        antrian : String,
        nama: String,
        umur: String,
        alamat: String,
        namaD: String,
        tanggal: String,
    ): Boolean {
        return !(TextUtils.isEmpty(antrian) && TextUtils.isEmpty(nama) && TextUtils.isEmpty(umur) && TextUtils.isEmpty(alamat) && TextUtils.isEmpty(namaD) && TextUtils.isEmpty(tanggal))
    }
}