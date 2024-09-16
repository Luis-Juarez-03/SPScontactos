package com.example.spscontactos.room.ER

import androidx.room.Entity
import androidx.room.PrimaryKey

class Contact {
    @Entity(tableName = "contacts")
    data class Contact(
        @PrimaryKey val id: Int,
        val email: String,
        val firstName: String,
        val lastName: String,
        val avatar: String, // This will store the avatar in base64
    )
}
