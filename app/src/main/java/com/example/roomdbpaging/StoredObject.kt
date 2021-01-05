package com.example.roomdbpaging

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StoredObject(
    @PrimaryKey val _id: Long,
    @ColumnInfo(name = "name") var name: String
)