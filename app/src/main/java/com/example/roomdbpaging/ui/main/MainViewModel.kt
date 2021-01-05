package com.example.roomdbpaging.ui.main

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.roomdbpaging.AppDatabase

class MainViewModel : ViewModel(app: Application) : AndroidViewModel(app) {

    val dao =  Room.databaseBuilder(app, AppDatabase::class.java, "myDb")
        .build()
        .storedObjectDao()
    val items = Pager(
        PagingConfig(
            pageSize = 50,
            enablePlaceholders = true,
        maxSize = 200
        )
    ) {
        dao.getAllPaged()
    }.flow
}