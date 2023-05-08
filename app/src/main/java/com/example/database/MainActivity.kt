package com.example.database

import android.app.backup.BackupAgentHelper
import android.app.backup.FileBackupHelper
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.database.Adapter.StudentAdapter
import com.example.database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private val TAG = "MainActivity"
lateinit var binding: ActivityMainBinding
lateinit var adapter: StudentAdapter
lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btninsert.setOnClickListener{

            var name = binding.name.text.toString()
            var surname = binding.surname.text.toString()
            var data = StudentModel(0,name, surname)
            dbHelper.addStudents(data)

            adapter.update(dbHelper.getStudents())
        }

        var list = dbHelper.getStudents()
        adapter = StudentAdapter(list)
        binding.rcvstudentlist.layoutManager = LinearLayoutManager(this)
        binding.rcvstudentlist.adapter = adapter

    }
}