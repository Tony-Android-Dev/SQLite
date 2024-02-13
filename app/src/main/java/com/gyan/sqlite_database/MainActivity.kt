package com.gyan.sqlite_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.gyan.sqlite_database.Database.DataModel
import com.gyan.sqlite_database.Database.DatabaseHelper
import com.gyan.sqlite_database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val db by lazy {

        DatabaseHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //CRUD OPERATION (CREATE,READ,UPDATE,DELETE OPERATIONS)

        binding.save.setOnClickListener{

            val title = binding.titleEt.text.toString()
            val content = binding.contentEt.text.toString()
            val dataModel = DataModel(0,title,content)
            db.insertData(dataModel)
            Snackbar.make(requireViewById(R.id.mainActivity),"Data added in db",Snackbar.LENGTH_LONG).show()

        }


    }
}