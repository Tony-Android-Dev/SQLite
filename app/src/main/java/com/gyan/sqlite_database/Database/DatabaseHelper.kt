package com.gyan.sqlite_database.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, db_name,null, db_version){

    companion object{

        private const val db_name = "TK_DATABASE"
        private const val db_version = 1
        private const val table_name = "UserTable"
        private const val id = "id"
        private const val title = "title"
        private const val cntnt = "content"
        private const val crud_op_createTable = "CREATE TABLE $table_name ($id INTEGER PRIMARY KEY, $title TEXT, $cntnt TEXT);"
        private const val crud_op_deleteTable = "DROP TABLE IF EXISTS $table_name"

    }

    override fun onCreate(db: SQLiteDatabase?) {
       db?.execSQL(crud_op_createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(crud_op_deleteTable)
        onCreate(db)
    }

    fun insertData(dataModel: DataModel){

        val db = writableDatabase
        val values = ContentValues().apply {

            put(title,dataModel.title)
            put(cntnt,dataModel.content)

        }

        db.insert(table_name,null,values)
        db.close()

    }

}