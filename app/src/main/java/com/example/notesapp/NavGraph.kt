package com.example.notesapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun SetUpNavGraph(viewModel: NoteViewModel,){

    val navController = rememberNavController()

    NavHost(navController= navController, startDestination = Screens.HomeScreen.routes) {

        composable(Screens.HomeScreen.routes){
            HomeScreen(navController,viewModel)
        }

        composable(Screens.NotesInputScreen.routes){
            NotesInputScreen(navController,viewModel)
        }


        composable(route = Screens.UpdateScreen.routes,
            arguments = listOf(navArgument("id"){type = NavType.IntType},
        )){
            backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            UpdateScreen(id,navController,viewModel)

        }

    }
}
