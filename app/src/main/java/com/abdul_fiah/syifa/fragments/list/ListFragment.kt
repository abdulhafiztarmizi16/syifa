package com.abdul_fiah.syifa.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdul_fiah.syifa.R
import com.abdul_fiah.syifa.viewmodel.PendaftaranViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private lateinit var mPendaftaranViewModel: PendaftaranViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val adapter = ListAdapter()
        val rv = view.recyclerview
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))

        mPendaftaranViewModel = ViewModelProvider(this).get(PendaftaranViewModel::class.java)
        mPendaftaranViewModel.bacaSemuaData.observe(viewLifecycleOwner, { pendaftaran ->
            adapter.tampilkanData(pendaftaran)
        })

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_tambahFragment)
        }

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_hapus, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_hapus){
            hapusSemua()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun hapusSemua(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Iya"){ _, _ ->
            mPendaftaranViewModel.hapusSemuaPendaftaran()
            Toast.makeText(requireContext(), "Semua data berhasil dihapus", Toast.LENGTH_SHORT)
                .show()
        }
        builder.setNegativeButton("Tidak"){ _, _ -> }
        builder.setTitle("Hapus semua?")
        builder.setMessage("Apakah kamu yakin ingin menghapus seluruh data ini?")
        builder.create().show()
    }

}