package org.mathieu.cleanrmapi.ui.screens.Locationdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.mathieu.cleanrmapi.domain.character.models.Character
import org.mathieu.cleanrmapi.domain.location.models.Location
import org.mathieu.cleanrmapi.ui.core.composables.BackArrow
import org.mathieu.cleanrmapi.ui.core.theme.PrimaryColor
import org.mathieu.cleanrmapi.ui.core.theme.SurfaceColor
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LocationDetailsScreen(
    navController: NavController,
    locationId: Int,
    viewModel: LocationDetailsViewModel = viewModel()
) {
    LaunchedEffect(locationId) {
        viewModel.init(locationId)
    }

    val state by viewModel.state

    Column(modifier = Modifier.fillMaxSize()) {
        BackArrow(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp),
            onClick = { navController.popBackStack() }
        )

        when (state) {
            is LocationDetailsState.Loading -> {
                Text(text = "Loading...")
            }
            is LocationDetailsState.Error -> {
                Text(text = "Error: ${(state as LocationDetailsState.Error).message}")
            }
            is LocationDetailsState.Loaded -> {
                val loadedState = state as LocationDetailsState.Loaded
                LocationDetails(location = loadedState.location)
                Text(
                    text = "Residents",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(loadedState.characters) { character ->
                        CharacterCard(character = character, onClick = {
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun LocationDetails(location: Location) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Location Name: ${location.name}",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Dimension: ${location.dimension}",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Type: ${location.type}",
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun CharacterCard(character: Character, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(SurfaceColor)
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Text(text = character.name, color = PrimaryColor)
    }
}