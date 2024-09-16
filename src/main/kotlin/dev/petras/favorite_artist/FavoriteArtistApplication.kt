package dev.petras.favorite_artist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FavoriteArtistApplication

fun main(args: Array<String>) {
	runApplication<FavoriteArtistApplication>(*args)
}
