package dev.petras.favorite_artist.search

import reactor.core.publisher.Mono

interface MusicService {
    fun getArtists(term: String): Mono<SearchResult>
    fun getTopAlbums(amgArtistId: Int): Mono<LookupResult>
}
