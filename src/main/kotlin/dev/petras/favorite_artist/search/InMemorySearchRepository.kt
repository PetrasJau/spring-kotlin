package dev.petras.favorite_artist.search

import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class InMemorySearchRepository : SearchRepository {
    // TODO: use redis or at least concurrent collections
    private val searchResults = mutableMapOf<String, SearchResult>() // term -> SearchResult
    private val topAlbumResults = mutableMapOf<Int, LookupResult>() // artistId ->

    override fun addSearchResult(term: String, searchResult: SearchResult) {
        searchResults[term] = searchResult
    }

    override fun getSearchResult(term: String): Mono<SearchResult> {
        return searchResults[term]?.let { Mono.just(it) } ?: Mono.empty()
    }

    override fun addAlbums(artistId: Int, searchResult: LookupResult) {
        topAlbumResults[artistId] = searchResult
    }

    override fun getAlbums(artistId: Int): Mono<LookupResult> {
        return topAlbumResults[artistId]?.let { Mono.just(it) } ?: Mono.empty()
    }
}