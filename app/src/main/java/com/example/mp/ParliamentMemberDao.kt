package com.example.mp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ParliamentMemberDao {
    @Query("SELECT * FROM parliament_members")
    fun getAllMembers(): Flow<List<ParliamentMember>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMembers(members: List<ParliamentMember>)
}