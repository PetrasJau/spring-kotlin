package dev.petras.favorite_artist.search

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class ItunesMusicService(private val builder: WebClient.Builder) : MusicService {
    // this is used as a workaround for itunes returning incompatible content type
    private val contentTypeReplacer = ExchangeFilterFunction.ofResponseProcessor { response ->
        Mono.just(
            response.mutate()
                .headers({ headers ->
                    headers.remove(
                        HttpHeaders.CONTENT_TYPE
                    )
                })
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
        )
    }
    private var webClient: WebClient =
        builder.baseUrl("https://itunes.apple.com/").filter(contentTypeReplacer)
            .build();

    override fun getArtists(term: String): Mono<SearchResult> {
        return webClient.get().uri("search?entity=allArtist&term=$term")
            .retrieve()
            .onStatus({ status -> status.isError }, { it.createException() }).bodyToMono(SearchResult::class.java)
    }

    override fun getTopAlbums(amgArtistId: Int): Mono<LookupResult> {
        return webClient.get().uri("lookup?entity=album&amgArtistId=$amgArtistId&limit=5")
            .retrieve()
            .onStatus({ status -> status.isError }, { it.createException() }).bodyToMono(LookupResult::class.java)
    }
}