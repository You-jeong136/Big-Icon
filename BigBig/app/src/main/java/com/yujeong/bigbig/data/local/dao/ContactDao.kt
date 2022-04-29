package com.yujeong.bigbig.data.local.dao

import androidx.room.*
import com.yujeong.bigbig.data.local.entity.ContactEntity

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllContacts(vararg contacts : ContactEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact : ContactEntity)

    @Query("SELECT * FROM contacts_table")
    fun getAllContacts() : List<ContactEntity>

    @Query("SELECT * FROM contacts_table WHERE id = :contactId")
    fun getContact(contactId : String) : ContactEntity?


}