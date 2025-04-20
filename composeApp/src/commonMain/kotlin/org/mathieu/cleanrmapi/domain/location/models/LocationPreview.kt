package org.mathieu.cleanrmapi.domain.location.models

/**
 * A lightweight representation of a location.
 *
 * @property id The unique identifier for the location.
 * @property name The name of the location.
 */
data class LocationPreview(
    val id: Int,
    val name: String
)
