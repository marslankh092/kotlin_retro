package com.example.kotlin_retro

import android.content.Context
import androidx.room.Database
import com.example.kotlin_retro.Search
import androidx.room.RoomDatabase
import com.example.kotlin_retro.MoviesDao
import com.example.kotlin_retro.RoomDbClient
import androidx.room.Room

@Database(entities = [Search::class], version = 1)
abstract class RoomDbClient : RoomDatabase() {
    abstract val dao: MoviesDao?
    fun cleanUp() {
        noteDB = null
    }

    companion object {
        public var noteDB: RoomDbClient? = null
        fun getInstance(context: Context): RoomDbClient? {
            if (null == noteDB) {
                noteDB = buildDatabaseInstance(context)
            }
            return noteDB
        }

        public fun buildDatabaseInstance(context: Context): RoomDbClient {
            return Room.databaseBuilder(
                context,
                RoomDbClient::class.java,
                "MoviesDb"
            )
                .allowMainThreadQueries().build()
        }
    }
}