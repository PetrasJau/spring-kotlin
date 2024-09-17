package dev.petras.favorite_artist.favorite

import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class InMemoryFavoriteRepository: FavoriteRepository {
    // TODO: use db or at least concurrent collections
    private var favorites: MutableMap<String, MutableSet<Int>> = mutableMapOf()

    override fun getFavorites(userId: String): Mono<Set<Int>> {
        return Mono.just(favorites[userId] ?: mutableSetOf())
    }

    override fun addFavorite(userId: String, artistId: Int): Mono<Int> {
        favorites[userId] = favorites[userId] ?: mutableSetOf()
        favorites[userId]?.add(artistId)
        return Mono.just(artistId)
    }

    override fun removeFavorite(userId: String, artistId: Int): Mono<Int> {
        favorites[userId]?.remove(artistId)
        return Mono.just(artistId)
    }

}