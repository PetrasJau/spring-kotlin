package dev.petras.favorite_artist.search

data class LookupResult(
    val resultCount: Int,
    val results: List<LookupResultItem>
)

data class LookupResultItem(
    val wrapperType: String?,
    val artistType: String?,
    var artistName: String?,
    val artistLinkUrl: String?,
    val artistId: Int,
    val amgArtistId: Int,
    val primaryGenreName: String?,
    val primaryGenreId: Int?
)
