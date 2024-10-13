package com.example.mp

import kotlinx.coroutines.flow.Flow

class ParliamentRepository(
    private val parliamentMemberDao: ParliamentMemberDao,
    private val parliamentApiService: ParliamentApiService
) {
    val allMembers: Flow<List<ParliamentMember>> = parliamentMemberDao.getAllMembers()

    suspend fun refreshMembers() {
        try {
            val members = parliamentApiService.getParliamentMembers()
            parliamentMemberDao.insertMembers(members)
        } catch (e: Exception) {
            // Handle error
        }
    }
}
