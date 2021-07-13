package com.kenneth.contactapp


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ContactViewModel: ViewModel() {

    fun addContactItem(
        contactItem: ContactModel,
        database: ContactDatabase){
        database.contactDao().addContactItem(contactItem)
    }

    fun getAllContactItems(database: ContactDatabase)
            :LiveData<List<ContactModel>> {
        return database.contactDao().getAllContactItems()
    }
}