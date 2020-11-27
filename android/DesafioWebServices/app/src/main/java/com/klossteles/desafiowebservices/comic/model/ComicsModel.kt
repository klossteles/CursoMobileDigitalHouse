package com.klossteles.desafiowebservices.comic.model

import com.klossteles.desafiowebservices.data.model.CharactersList
import com.klossteles.desafiowebservices.data.model.CreatorsList
import com.klossteles.desafiowebservices.data.model.ThumbnailModel
import com.klossteles.desafiowebservices.data.model.UrlModel
import java.util.*

class ComicsModel (
    val id: Int?,
    val digitalId: Int?,
    val title: String?,
    val issueNumber: Double?,
    val variantDescription: String?,
    val description: String?,
    val modified: Date?,
    val isbn: String?,
    val upc: String?,
    val diamondCode: String?,
    val ean: String?,
    val issn: String?,
    val format: String?,
    val pageCount: Int?,
    val textObjects: List<TextObjectModel>?,
    val resoucerURI: String?,
    val urls: List<UrlModel>?,
    val variants: List<ComicSummaryModel>?,
    val collections: List<ComicSummaryModel>?,
    val collectedIssues: List<ComicSummaryModel>?,
    val dates: List<ComicDate>?,
    val prices: List<ComicPrice>?,
    val thumbnail: ThumbnailModel?,
    val images: List<ThumbnailModel>?,
    val creators: CreatorsList?,
    val characters: CharactersList?
)