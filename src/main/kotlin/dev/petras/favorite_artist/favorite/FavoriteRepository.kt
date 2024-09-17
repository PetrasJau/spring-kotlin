package dev.petras.favorite_artist.favorite

import reactor.core.publisher.Mono

interface FavoriteRepository {
    fun getFavorites(userId: String): Mono<Set<Int>>
    fun addFavorite(userId: String, artistId: Int): Mono<Int>
    fun removeFavorite(userId: String, artistId: Int): Mono<Int>
}