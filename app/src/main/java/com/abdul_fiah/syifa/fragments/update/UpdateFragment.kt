package com.abdul_fiah.syifa.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.abdul_fiah.syifa.R
import com.abdul_fiah.syifa.model.Pendaftaran
import com.abdul_fiah.syifa.viewmodel.PendaftaranViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mPendaftaranViewModel: PendaftaranViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mPendaftaranViewModel = ViewModelProvider(this).get(PendaftaranViewModel::class.java)
        view.edt_update_antrian.setText(args.curPendaftaran.antrian)
        view.edt_update_nama.setText(args.curPendaftaran.nama)
        view.edt_update_umur.setText(args.curPendaftaran.umur)
        view.edt_update_alamat.setText(args.curPendaftaran.alamat)
        view.edt_update_dokter.setText(args.curPendaftaran.namaD)
        view.edt_update_tanggal.setText(args.curPendaftaran.tanggal)

        view.btn_update.setOnClickListener{
            updateItem()
        }
        setHasOptionsMenu(true)
        return view
    }

    private fun updateItem(){
        val antrian = edt_update_antrian.text.toString()
        val nama = edt_update_nama.text.toString()
        val umur = edt_update_umur.text.toString()
        val alamat = edt_update_alamat.text.toString()
        val dokter = edt_update_dokter.text.toString()
        val tanggal = edt_update_tanggal.text.toString()

        if(cekInput(antrian, nama, umur, alamat, dokter, tanggal)){
            val updatedData = Pendaftaran(args.curPendaftaran.id, antrian, nama, umur, alamat, dokter, tanggal)
            mPendaftaranViewModel.updatePendaftaran(updatedData)

            Toast.makeText(requireContext(), "Data berhasil di Update", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Silahkan isi semua data", Toast.LENGTH_SHORT)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_hapus, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_hapus){
            hapusPendaftaran()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun hapusPendaftaran(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Iya"){ _, _ ->
            mPendaftaranViewModel.hapusPendaftaran(args.curPendaftaran)
            Toast.makeText(
                requireContext(),
                "Pendaftaran ${args.curPendaftaran.antrian} berhasil dihapus",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("Tidak"){_, _ -> }
        builder.setTitle("Hapus ${args.curPendaftaran.antrian} ?")
        builder.setMessage("Apakah kamu yakin ingin menghapus data ini?")
        builder.create().show()
    }

}