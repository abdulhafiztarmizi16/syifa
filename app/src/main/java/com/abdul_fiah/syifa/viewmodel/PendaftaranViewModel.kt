package com.abdul_fiah.syifa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.abdul_fiah.syifa.model.Pendaftaran
import com.abdul_fiah.syifa.data.PendaftaranDb
import com.abdul_fiah.syifa.repository.PendaftaranRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PendaftaranViewModel(application: Application): AndroidViewModel(application) {

    val bacaSemuaData: LiveData<List<Pendaftaran>>
    private val repo: PendaftaranRepo

    init {
        val pendaftaranDAO = PendaftaranDb.getDb(application).pendaftaranDAO()
        repo = PendaftaranRepo(pendaftaranDAO)
        bacaSemuaData = repo.bacaSemuaData
    }

    fun tambahPendaftaran(pendaftaran: Pendaftaran){
        viewModelScope.launch(Dispatchers.IO) {
            repo.tambahPasien(pendaftaran)
        }
    }
    fun updatePendaftaran(pendaftaran: Pendaftaran){
        viewModelScope.launch(Dispatchers.IO) {
            repo.updatePasien(pendaftaran)
        }
    }
    fun hapusPendaftaran(pendaftaran: Pendaftaran){
        viewModelScope.launch(Dispatchers.IO) {
            repo.hapusPasien(pendaftaran)
        }
    }
    fun hapusSemuaPendaftaran(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.hapusSemuaPendaftaran()
        }
    }


}