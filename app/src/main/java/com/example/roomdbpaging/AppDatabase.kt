package com.example.roomdbpaging

import androidx.room.RoomDatabase

@Database(entities = arrayOf(StoredObject::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun storedObjectDao(): storedObjectDao
}