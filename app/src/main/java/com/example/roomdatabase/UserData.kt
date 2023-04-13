package com.example.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "FIRSTNAME")
    val firstname: String,
    @ColumnInfo(name = "LASTNAME")
    val lastname: String,
    @ColumnInfo(name = "ROLL")
    val roll: String
)
