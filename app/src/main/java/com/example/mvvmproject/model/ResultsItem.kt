package com.example.mvvmproject.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Response(

	@field:SerializedName("results")
	val results: List<ResultsItem>,

	@field:SerializedName("info")
	val info: Info? = null
) : Parcelable

@Parcelize
data class ResultsItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("species")
	val species: String? = null,

	@field:SerializedName("created")
	val created: String? = null,

	@field:SerializedName("origin")
	val origin: Origin? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("episode")
	val episode: List<String?>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable

@Parcelize
data class Info(

	@field:SerializedName("next")
	val next: String? = null,

	@field:SerializedName("pages")
	val pages: Int? = null,

	@field:SerializedName("prev")
	val prev: String? = null,

	@field:SerializedName("count")
	val count: Int? = null
) : Parcelable

@Parcelize
data class Location(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

@Parcelize
data class Origin(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable
