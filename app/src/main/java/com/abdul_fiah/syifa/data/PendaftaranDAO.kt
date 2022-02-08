package com.abdul_fiah.syifa.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.abdul_fiah.syifa.model.Pendaftaran

@Dao
interface PendaftaranDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun tambahPasien(pendaftaran: Pendaftaran)

    @Query("SELECT * FROM daftar_pasien ORDER BY id ASC")
    fun bacaSemuaData(): LiveData<List<Pendaftaran>>

    @Update
    suspend fun updatePasien(pendaftaran: Pendaftaran)

    @Delete
    suspend fun hapusPasien(pendaftaran: Pendaftaran)

    @Query("DELETE FROM daftar_pasien")
    suspend fun hapusSemua()

}