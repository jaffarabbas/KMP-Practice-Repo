package org.bggeolocation.com

import kotlinx.coroutines.flow.Flow

interface ILocationTracker {
    fun startTracking()
    fun stopTracking()
    fun getCurrentLocation(): Location?
    fun getLocationFlow(): Flow<Location>
}

data class Location(val latitude: Double, val longitude: Double)