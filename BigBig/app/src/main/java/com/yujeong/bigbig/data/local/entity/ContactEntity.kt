package com.yujeong.bigbig.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "contacts_table")
data class ContactEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "tel")
    val tel : String,
    @ColumnInfo(name = "image_uri")
    val imageUri : String,
)