package com.kenneth.contactapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = arrayOf(ContactModel::class),
    version = 1
)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDAO
}