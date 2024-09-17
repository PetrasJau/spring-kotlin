package dev.petras.favorite_artist.search

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MusicFacade(private val musicService: ItunesMusicService, private val searchRepository: SearchRepository) :
    MusicService {

    override fun getArtists(term: String): Mono<SearchResult> {
        return searchRepository.getSearchResult(term)
            .switchIfEmpty(Mono.defer({
                musicService.getArtists(term).doOnNext({ searchRepository.addSearchResult(term, it) })
            }))
            .onErrorResume { Mono.empty() }
    }

    override fun getTopAlbums(amgArtistId: Int): Mono<LookupResult> {
        return searchRepository.getAlbums(amgArtistId)
            .switchIfEmpty(Mono.defer({
                musicService.getTopAlbums(amgArtistId).doOnNext({ searchRepository.addAlbums(amgArtistId, it) })
            }))
            .onErrorResume { Mono.empty() }
    }
}