package com.example.roomdbpaging.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.example.roomdbpaging.AppDatabase
import com.example.roomdbpaging.R
import com.example.roomdbpaging.StoredObject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        prePopDB()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

    }

    fun prePopDB() {

        val dao = Room.databaseBuilder(context!!, AppDatabase::class.java, "myDb")
            .build()
            .storedObjectDao()
        GlobalScope.launch {
            for (i in 0..50) {
               val result = dao.insert(StoredObject(_id = 0, name = "name$i"))
                Log.d("mainactivity", "Result: $result")
            }
        }

    }

}