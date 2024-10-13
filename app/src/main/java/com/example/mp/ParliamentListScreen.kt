package com.example.mp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun ParliamentListScreen(viewModel: ParliamentViewModel) {
    val members by viewModel.allMembers.collectAsState()

    LazyColumn {
        items(members) { member ->
            Text(text = "${member.firstName} ${member.lastName}")
        }
    }
}