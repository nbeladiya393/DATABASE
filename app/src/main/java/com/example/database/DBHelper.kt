package com.example.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.nfc.Tag
import android.util.Log

class DBHelper (
    context: Context?,


        ) : SQLiteOpenHelper(context, "My Data", null, 1) {

    private val TAG= "DBHelper"
    val TABLE_NAME = "STUDENT_DETAILS"
    override fun onCreate(p0: SQLiteDatabase?) {
        var sql = "CREATE TABLE $TABLE_NAME(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, surname TEXT)"
        p0?.execSQL(sql)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
    fun addStudents(stdData: StudentModel) {

        var db = writableDatabase
        var values = ContentValues().apply {

            put("name",stdData.name)
            put("surname",stdData.surname)

        }

        var iss = db.insert(TABLE_NAME, null,values)
        if (iss.toInt()== -1){
            Log.e(TAG, "addStudents: =============== DATA IS NOT INSERTED" )
        }else {
            Log.e(TAG, "addStudents: ================ DATA INSTERTED" )
        }
    }

    fun getStudents(): ArrayList<StudentModel>{
        var studentList = ArrayList<StudentModel>()
        var  db = readableDatabase
        var sql = "SELECT * FROM $TABLE_NAME"
        var  cursor:Cursor = db.rawQuery(sql, null)
        cursor.moveToFirst()

        for (i in 0..cursor.count-1){
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var surname = cursor.getString(2)
            var model = StudentModel(id, name, surname)
            studentList.add(model)
            cursor.moveToNext()
        }

        return studentList
    }
}
