package org.bggeolocation.com

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform