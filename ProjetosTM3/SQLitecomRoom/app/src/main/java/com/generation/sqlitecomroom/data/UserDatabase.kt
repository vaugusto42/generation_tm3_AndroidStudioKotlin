package com.generation.sqlitecomroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
abstract class UserDatabase : RoomDatabase(){

    abstract fun userDao(): UserDAO

    companion object{
        @Volatile //queremos que essa var fique visivel a todas as threads do app a partir do momento que for instanciada

        //n kotlin in order to force changes in a variable to be immediately visible to other threads, we can use the annotation @Volatile.]
        // If a variable is not shared between multiple threads, you don't need to use volatile keyword with that variable.
        //In other words, When you apply volatile to a field of a class,
        // It instructs the CPU to always read it from the RAM and not from the CPU cache.
        // It also prevents instructions reordering; it acts as a memory barrier.
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}