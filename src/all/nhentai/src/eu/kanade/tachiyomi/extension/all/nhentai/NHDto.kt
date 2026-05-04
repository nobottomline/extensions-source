package eu.kanade.tachiyomi.extension.all.nhentai

import kotlinx.serialization.Serializable

@Serializable
class Hentai(
    var id: Int,
    val images: Images,
    val media_id: String,
    val tags: List<Tag>,
    val title: Title,
    val upload_date: Long,
    val num_favorites: Long,
)

@Serializable
class Title(
    var english: String? = null,
    val japanese: String? = null,
    val pretty: String? = null,
)

@Serializable
class Images(
    val pages: List<Image>,
)

@Serializable
class Image(
    private val t: String,
) {
    val extension get() = when (t) {
        "w" -> "webp"
        "p" -> "png"
        "g" -> "gif"
        else -> "jpg"
    }
}

@Serializable
class Tag(
    val name: String,
    val type: String,
)

@Serializable
class ApiGallery(
    val id: Int,
    val media_id: String,
    val title: ApiTitle,
    val cover: ApiImage,
    val thumbnail: ApiImage,
    val scanlator: String = "",
    val upload_date: Long,
    val tags: List<ApiTag>,
    val num_pages: Int,
    val num_favorites: Long,
    val pages: List<ApiPage> = emptyList(),
)

@Serializable
class ApiTitle(
    val english: String,
    val japanese: String? = null,
    val pretty: String,
)

@Serializable
class ApiImage(
    val path: String,
    val width: Int,
    val height: Int,
)

@Serializable
class ApiPage(
    val number: Int,
    val path: String,
    val width: Int,
    val height: Int,
    val thumbnail: String,
    val thumbnail_width: Int,
    val thumbnail_height: Int,
)

@Serializable
class ApiTag(
    val id: Int,
    val type: String,
    val name: String,
    val slug: String,
    val url: String,
    val count: Int,
)
