package com.example.mp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parliament_members")
data class ParliamentMember(
    @PrimaryKey val id: String,
    val firstName: String,
    val lastName: String,
    val party: String,
    val pictureUrl: String
)