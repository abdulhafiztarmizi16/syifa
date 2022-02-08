package com.abdul_fiah.syifa.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "daftar_pasien")
data class Pendaftaran(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val antrian: String,
    val nama: String,
    val umur: String,
    val alamat: String,
    val namaD: String,
    val tanggal: String,
): Parcelable
