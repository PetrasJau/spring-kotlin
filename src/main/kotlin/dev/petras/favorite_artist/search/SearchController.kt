package dev.petras.favorite_artist.search

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/search")
class SearchController(private val musicFacade: MusicFacade) {

    @GetMapping("/artists")
    fun search(term: String): Mono<SearchResult> {
        return musicFacade.getArtists(term)
    }

    @GetMapping("/albums")
    fun search(amgArtistId: Int): Mono<LookupResult> {
        return musicFacade.getTopAlbums(amgArtistId)
    }
}