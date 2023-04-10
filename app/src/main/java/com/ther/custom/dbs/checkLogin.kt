package com.ther.custom.dbs

import android.content.Context
import com.ther.custom.dbs.DBRepo

fun checkLogin(context: Context, user:String, password:String): Boolean {

    val db = DBRepo()

    val result = db.login(context, user, password)

    return result
}



