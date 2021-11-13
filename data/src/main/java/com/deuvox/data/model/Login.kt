package com.deuvox.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "login")
@Parcelize
data class Login(
    @PrimaryKey
    val username: String,

    @ColumnInfo(name = "password")
    val password: String
): Parcelable