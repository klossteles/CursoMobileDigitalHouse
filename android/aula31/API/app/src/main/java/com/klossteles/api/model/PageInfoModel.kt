package com.klossteles.api.model

data class PageInfoModel (
//    @SerializedName("count")
//    val total: Int
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?,
)
