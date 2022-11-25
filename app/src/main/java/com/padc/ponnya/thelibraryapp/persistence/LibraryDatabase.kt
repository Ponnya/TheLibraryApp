package com.padc.ponnya.thelibraryapp.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.data.vos.ShelfWithBookVO
import com.padc.ponnya.thelibraryapp.persistence.daos.BookDao
import com.padc.ponnya.thelibraryapp.persistence.daos.ShelfDao
import com.padc.ponnya.thelibraryapp.persistence.daos.ShelfWithBookDao

@Database(
    entities = [BookVO::class, ShelfVO::class, ShelfWithBookVO::class],
    version = 10,
    exportSchema = false
)
abstract class LibraryDatabase : RoomDatabase() {
    companion object {
        private const val DB_NAME = "THE_LIBRARY_DB"
        var dbInstant: LibraryDatabase? = null
        fun getDBInstance(context: Context): LibraryDatabase? {
            when (dbInstant) {
                null -> {
                    dbInstant = Room.databaseBuilder(context, LibraryDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return dbInstant
        }
    }

    abstract fun bookDao(): BookDao
    abstract fun shelfDao(): ShelfDao
    abstract fun shelfWithBookDao(): ShelfWithBookDao
}