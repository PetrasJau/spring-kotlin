package dev.petras.favorite_artist.favorite

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/favorite")
class FavoriteController(private val favoriteRepository: FavoriteRepository) {

    @GetMapping("/")
    fun getFavorites(@RequestHeader("userId") userId: String): Mono<Set<Int>> {
        return favoriteRepository.getFavorites(userId)
    }

    @PostMapping("/")
    fun addFavorite(@RequestHeader("userId") userId: String, artistId: Int): Mono<Int> {
        return favoriteRepository.addFavorite(userId, artistId)
    }

    @DeleteMapping("/")
    fun removeFavorite(@RequestHeader("userId") userId: String, artistId: Int): Mono<Int> {
        return favoriteRepository.removeFavorite(userId, artistId)
    }
}