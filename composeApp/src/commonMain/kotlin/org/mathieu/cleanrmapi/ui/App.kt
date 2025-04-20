package org.mathieu.cleanrmapi.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.KoinContext
import org.mathieu.cleanrmapi.ui.core.Destination
import org.mathieu.cleanrmapi.ui.core.composable
import org.mathieu.cleanrmapi.ui.screens.Locationdetails.LocationDetailsScreen
import org.mathieu.cleanrmapi.ui.screens.characterdetails.CharacterDetailsScreen
import org.mathieu.cleanrmapi.ui.screens.characters.CharactersScreen
import org.mathieu.cleanrmapi.ui.screens.episodedetails.EpisodeDetailsScreen

@Composable
fun App() {
    KoinContext {
        MainContent()
    }

}

@Composable
private fun MainContent() {

    val navController = rememberNavController()

    //https://developer.android.com/jetpack/compose/navigation?hl=fr
    NavHost(navController = navController, startDestination = "characters") {

        composable(Destination.Characters) { CharactersScreen(navController) }

        composable(
            destination = Destination.CharacterDetails()
        ) { backStackEntry ->

            CharacterDetailsScreen(
                navController = navController,
                id = backStackEntry.arguments?.getInt("characterId") ?: -1
            )
        }

        composable(
            destination = Destination.EpisodeDetails()
        ) { backStackEntry ->

            EpisodeDetailsScreen(
                navController = navController,
                id = backStackEntry.arguments?.getInt("episodeId") ?: -1
            )
        }


        composable(
            "location_details_screen/{locationId}" // Spécifiez la route avec l'ID de la location
        ) { backStackEntry ->

            val locationId = backStackEntry.arguments?.getString("locationId")?.toIntOrNull() ?: -1
            LocationDetailsScreen(
                navController = navController,
                locationId = locationId
            )
        }
    }
}