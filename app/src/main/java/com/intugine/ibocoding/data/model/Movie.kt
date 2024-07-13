package com.intugine.ibocoding.data.model


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("actors")
    val actors: String?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("date_released")
    val dateReleased: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("director")
    val director: String?,
    @SerializedName("image_landscape")
    val imageLandscape: String?,
    @SerializedName("image_portrait")
    val imagePortrait: String?,
    @SerializedName("imdb")
    val imdb: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("netflixid")
    val netflixid: String?,
    @SerializedName("quality")
    val quality: String?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("runtime")
    val runtime: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("titlereleased")
    val titlereleased: String?,
    @SerializedName("type")
    val type: String?
)