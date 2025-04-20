package org.mathieu.cleanrmapi.data.remote.responses

import kotlinx.serialization.Serializable

/**
 * Represents the information about a Location, typically received from an API response.
 *
 * @property id Unique identifier of the location.
 * @property name Name of the location.
 * @property type Le type de location.
 * @property dimension La dimension dans laquelle la location est située.
 * @property residentsIds Liste d’IDs de [Character] présents dans l’emplacement.
 * @property url The unique URL endpoint specifically for this character.
 * @property created The timestamp indicating when the character was added to the database.
 */
@Serializable
data class LocationResponse(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)