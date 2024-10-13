package com.example.mp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ParliamentViewModel(private val repository: ParliamentRepository) : ViewModel() {
    val allMembers: StateFlow<List<ParliamentMember>> = repository.allMembers.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun refreshMembers() {
        viewModelScope.launch {
            repository.refreshMembers()
        }
    }
}