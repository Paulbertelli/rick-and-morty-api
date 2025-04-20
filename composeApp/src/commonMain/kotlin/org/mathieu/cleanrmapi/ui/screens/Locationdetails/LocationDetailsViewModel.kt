package org.mathieu.cleanrmapi.ui.screens.Locationdetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.mathieu.cleanrmapi.domain.character.models.Character
import org.mathieu.cleanrmapi.domain.location.LocationRepository
import org.mathieu.cleanrmapi.domain.location.models.Location

sealed class LocationDetailsState {
    object Loading : LocationDetailsState()
    data class Error(val message: String) : LocationDetailsState()
    data class Loaded(
        val location: Location,
        val characters: List<Character>
    ) : LocationDetailsState()
}

class LocationDetailsViewModel : ViewModel(), KoinComponent {
    private val locationRepository: LocationRepository by inject()

    private val _state = mutableStateOf<LocationDetailsState>(LocationDetailsState.Loading)
    val state: State<LocationDetailsState> get() = _state

    fun init(locationId: Int) {
        viewModelScope.launch {
            try {
                val location= locationRepository.getLocation(locationId)

                val characters = location.residents

                _state.value = LocationDetailsState.Loaded(location = location, characters = characters)
            } catch (e: Exception) {
                _state.value = LocationDetailsState.Error(message = e.message ?: "Unknown error")
            }
        }
    }
}