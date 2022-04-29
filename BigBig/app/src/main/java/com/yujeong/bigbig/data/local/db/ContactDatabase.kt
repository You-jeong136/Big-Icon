package com.yujeong.bigbig.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yujeong.bigbig.data.local.dao.ContactDao
import com.yujeong.bigbig.data.local.entity.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun ContactDao() : ContactDao

    companion object{
        private var instance : ContactDatabase? = null

        @JvmStatic
        fun getInstance(context : Context) : ContactDatabase{
            return instance ?: synchronized(this){
                newInstance(context).also{ instance = it }
            }
        }

        @JvmStatic
        fun newInstance(context: Context) : ContactDatabase{
            return Room.databaseBuilder(
                context, ContactDatabase::class.java, "ContactDatabase"
            ).build()
        }
    }
}