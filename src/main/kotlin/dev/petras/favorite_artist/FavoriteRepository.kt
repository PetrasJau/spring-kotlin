package dev.petras.favorite_artist

import org.springframework.stereotype.Repository

@Repository
class FavoriteRepository {
    private var favorites: MutableMap<String, MutableSet<String>> = mutableMapOf()

    fun getFavorites(userId: String): Set<String> {
        return favorites[userId] ?: mutableSetOf()
    }

    fun addFavorite(userId: String, artistId: String) {
        favorites[userId] = favorites[userId] ?: mutableSetOf()
        favorites[userId]?.add(artistId)
    }

    fun removeFavorite(userId: String, artistId: String) {
        favorites[userId]?.remove(artistId)
    }

}