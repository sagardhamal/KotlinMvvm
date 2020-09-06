package com.pibusa.firstmvvmapp.data.db

import android.icu.text.Replaceable
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.pibusa.firstmvvmapp.data.db.entites.CURRENT_USER_ID
import com.pibusa.firstmvvmapp.data.db.entites.UserDb

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun userInsert(user: UserDb): Long

    @Query("SELECT * FROM userdb Where id=$CURRENT_USER_ID")
    fun getUser(): LiveData<UserDb>

}
