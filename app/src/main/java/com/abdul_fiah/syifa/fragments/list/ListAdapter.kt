package com.abdul_fiah.syifa.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.abdul_fiah.syifa.R
import com.abdul_fiah.syifa.model.Pendaftaran
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var pendaftaranList = emptyList<Pendaftaran>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_row, parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curItem = pendaftaranList[position]
        holder.itemView.tx_antrian.text = curItem.antrian
        holder.itemView.tx_nama.text = curItem.nama
        holder.itemView.tx_umur.text = curItem.umur
        holder.itemView.tx_alamat.text = curItem.alamat
        holder.itemView.tx_namaDokter.text = curItem.namaD
        holder.itemView.tx_tanggal.text = curItem.tanggal

        holder.itemView.custom_row.setOnClickListener{
            val aksi = ListFragmentDirections.actionListFragmentToUpdateFragment(curItem)
            holder.itemView.findNavController().navigate(aksi)
        }
    }

    fun tampilkanData(pendaftaran: List<Pendaftaran>){
        this.pendaftaranList = pendaftaran
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return pendaftaranList.size
    }

}