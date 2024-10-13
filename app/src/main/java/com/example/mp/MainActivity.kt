package com.example.mp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mp.ui.theme.ParliamentMembersTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParliamentMembersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ParliamentApp()
                }
            }
        }
    }
}

@Composable
fun ParliamentApp() {
    val navController = rememberNavController()
    val viewModel: ParliamentViewModel = viewModel()

    NavHost(navController = navController, startDestination = "memberList") {
        composable("memberList") {
            ParliamentListScreen(viewModel = viewModel)
        }
    }
}