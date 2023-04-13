package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1 , exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun AppDao(): AppDao


 companion  object DatabaseBuilder {
     @Volatile
        private var INSTANCE: AppDatabase? = null
        fun buildRoomDB(context: Context): AppDatabase {

            return INSTANCE ?: synchronized(this) {
              val instance=  Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Room_Databae"
                ).build()
             INSTANCE=instance
             instance
            }
        }
    }

}
