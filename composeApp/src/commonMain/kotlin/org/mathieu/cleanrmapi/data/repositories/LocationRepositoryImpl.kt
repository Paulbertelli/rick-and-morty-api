package org.mathieu.cleanrmapi.data.repositories

import org.mathieu.cleanrmapi.domain.character.models.Character
import org.mathieu.cleanrmapi.data.local.CharacterDAO
import org.mathieu.cleanrmapi.data.local.LocationDAO
import org.mathieu.cleanrmapi.data.local.objects.LocationObject
import org.mathieu.cleanrmapi.data.remote.LocationApi
import org.mathieu.cleanrmapi.domain.location.LocationRepository
import org.mathieu.cleanrmapi.domain.location.models.Location
import org.mathieu.cleanrmapi.data.local.objects.toDBObject
import org.mathieu.cleanrmapi.data.local.objects.toModel
import org.mathieu.cleanrmapi.domain.character.CharacterRepository

internal class LocationRepositoryImpl(
    private val locationApi: LocationApi,
    private val locationDAO: LocationDAO,
    private val characterRepository: CharacterRepository
) : LocationRepository {

    override suspend fun getLocation(id: Int): Location {
        val locationObject = GetLocationObjectIfExists(id, locationApi, locationDAO)

        val residents = characterRepository.getCharactersFromUrls(locationObject.residentsIds.split(","))

        return locationObject.toModel(residents)
    }
}

private suspend fun GetLocationObjectIfExists(
    locationId: Int,
    locationApi: LocationApi,
    locationDAO: LocationDAO
): LocationObject {
    return tryToGetLocationLocally(locationDAO, locationId)
        .fetchRemotelyIfNotFound(locationApi, locationDAO, locationId)
        .throwIfWeCannotFindIt()
}

private suspend fun tryToGetLocationLocally(locationDAO: LocationDAO, id: Int): LocationObject? {
    return locationDAO.getLocationById(id)
}

private suspend fun LocationObject?.fetchRemotelyIfNotFound(
    locationApi: LocationApi,
    locationDAO: LocationDAO,
    id: Int
): LocationObject? {
    if (this != null) return this

    val remote = locationApi.getLocation(id)
    val dbObject = remote.toDBObject()
    locationDAO.insertLocation(dbObject)
    return dbObject
}

private fun LocationObject?.throwIfWeCannotFindIt(): LocationObject {
    if (this != null) return this
    throw Exception("Could not find Location locally and remotely.")
}

private suspend fun idsToCharactersConverter(
    idsString: String,
    dao: CharacterDAO
): List<Character> {
    val ids = idsString
        .split(",")
        .mapNotNull { it.trim().toIntOrNull() }

    return dao.getCharactersByIds(ids).map { it.toModel() }
}
