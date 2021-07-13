package com.kenneth.contactapp


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {
    @Insert
    fun addContactItem(contactItem: ContactModel)

    @Query("SELECT * from contactmodel")
    fun getAllContactItems(): LiveData<List<ContactModel>>

    @Delete
    fun delete(contactItem: ContactModel)
}