package dev.petras.favorite_artist.search

import reactor.core.publisher.Mono

interface SearchRepository {
    fun addSearchResult(term: String, searchResult: SearchResult)
    fun getSearchResult(term: String): Mono<SearchResult>
    fun addAlbums(artistId: Int, searchResult: LookupResult)
    fun getAlbums(artistId: Int): Mono<LookupResult>
}