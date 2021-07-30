package com.litziy.kawalcovid.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri

class MedicineDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {


    companion object {
        private const val DB_NAME = "medicine.db"
        private const val DB_VERSION = 1

        const val AUTHORITY = "com.litziy.kawalcovid"
        const val SCHEME = "content"

        const val TABLE_MEDICINE = "table_medicine"
        const val KEY_ID = "_id"
        const val KEY_NAME = "name"
        const val KEY_DESC = "desc"

        val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_MEDICINE)
                .build()

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_MEDICINE (" +
                "$KEY_ID INTEGER PRIMARY KEY," +
                "$KEY_NAME   TEXT," +
                "$KEY_DESC TEXT" +
                ")")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_MEDICINE")
    }


}