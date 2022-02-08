package com.abdul_fiah.syifa.repository

import androidx.lifecycle.LiveData
import com.abdul_fiah.syifa.data.PendaftaranDAO
import com.abdul_fiah.syifa.model.Pendaftaran


class PendaftaranRepo(private  val pendaftaranDAO: PendaftaranDAO) {

    val bacaSemuaData: LiveData<List<Pendaftaran>> = pendaftaranDAO.bacaSemuaData()

    suspend fun tambahPasien(pendaftaran:Pendaftaran){
        pendaftaranDAO.tambahPasien(pendaftaran)
    }

    suspend fun updatePasien(pendaftaran:Pendaftaran) {
        pendaftaranDAO.updatePasien(pendaftaran)
    }

    suspend fun hapusPasien(pendaftaran:Pendaftaran) {
        pendaftaranDAO.hapusPasien(pendaftaran)
    }

    suspend fun hapusSemuaPendaftaran(){
        pendaftaranDAO.hapusSemua()
    }



}