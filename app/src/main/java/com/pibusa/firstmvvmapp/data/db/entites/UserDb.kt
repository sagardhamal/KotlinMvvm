package com.pibusa.firstmvvmapp.data.db.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
data class UserDb(
    var id: Int? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var email_varified_at: String? = null,
    var created_at: String? = null,
    var udated_at: String? = null


) {
    @PrimaryKey(autoGenerate = false)
    var uId: Int = CURRENT_USER_ID
}