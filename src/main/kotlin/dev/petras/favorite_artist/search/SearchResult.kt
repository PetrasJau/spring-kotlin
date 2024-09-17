package dev.petras.favorite_artist.search

data class SearchResult(
    val resultCount: Int,
    val results: List<SearchResultItem>
)

data class SearchResultItem(
    val wrapperType: String?,
    val artistType: String?,
    val artistName: String?,
    val artistLinkUrl: String?,
    val artistId: Int,
    val primaryGenreName: String?,
    val primaryGenreId: Int?
)
