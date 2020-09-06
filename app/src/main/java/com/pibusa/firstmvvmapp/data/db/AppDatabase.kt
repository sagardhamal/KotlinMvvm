package com.pibusa.firstmvvmapp.data.db.entites

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pibusa.firstmvvmapp.data.db.UserDao


@Database(
    entities = [UserDb::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(cotext: Context) =
            Room.databaseBuilder(cotext.applicationContext, AppDatabase::class.java, "pibusa.db")
                .build()
    }
}