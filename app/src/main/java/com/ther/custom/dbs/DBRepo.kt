package com.ther.custom.dbs

import android.content.Context

class DBRepo {
    fun login(context: Context, user: String, password: String): Boolean {
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", arrayOf(user, password))

        val result = cursor.moveToNext()

        db.close()

        return result
    }
}