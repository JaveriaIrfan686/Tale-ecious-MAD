package com.example.taleecious

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val databaseName = "myDB"
val tableName = "Feedback_Table"
val col_name = "Name"
val col_feedback = "Feedback"
val col_id = "id"

class databaseHandler(var context: Context) : SQLiteOpenHelper(context, databaseName, null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable = "CREATE TABLE "+ tableName + " (" +
                col_id + "INTEGER PRIMARY KEY AUTOINCREAMENT," +
                col_name + " VARCHAR(256)," +
                col_feedback + " VARCHAR(256))"

        p0?.execSQL(createTable)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user : userDatabase) {
         val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(col_name, user.name)
        cv.put(col_feedback, user.feedback)
        var result = db.insert(tableName, null, cv)
        if (result == -1.toLong()) {
            Toast.makeText(context, "Unable to SEND your feedback", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Thank you for your FEEDBACK", Toast.LENGTH_SHORT).show()
        }

    }

}