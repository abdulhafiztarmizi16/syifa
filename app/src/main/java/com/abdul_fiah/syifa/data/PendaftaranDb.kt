package com.abdul_fiah.syifa.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abdul_fiah.syifa.model.Pendaftaran

@Database(entities = [Pendaftaran::class], version = 1, exportSchema = false)
abstract class PendaftaranDb : RoomDatabase(){

    abstract fun pendaftaranDAO(): PendaftaranDAO

    companion object{
        @Volatile
        private var INSTANCE: PendaftaranDb? = null

        fun getDb(context: Context): PendaftaranDb{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PendaftaranDb::class.java,
                    "daftar_pasien"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}

