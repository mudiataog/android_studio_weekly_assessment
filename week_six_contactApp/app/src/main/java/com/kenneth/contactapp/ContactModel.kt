package com.kenneth.contactapp

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class ContactModel(
    val name: String,
    val phoneNumber: String,

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
)
