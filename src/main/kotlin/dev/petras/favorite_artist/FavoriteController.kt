package dev.petras.favorite_artist

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/favorite")
class FavoriteController(private val favoriteRepository: FavoriteRepository) {

    @GetMapping("/")
    fun getFavorites(): Set<String> {
        return favoriteRepository.getFavorites("userId")
    }

    @PostMapping("/")
    fun addFavorite(artistId: String) {
        favoriteRepository.addFavorite("userId", artistId)
    }

    @DeleteMapping("/")
    fun removeFavorite(artistId: String) {
        favoriteRepository.removeFavorite("userId", artistId)
    }
}