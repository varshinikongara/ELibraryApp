package varshinikongara.s3537641.elibraryapp.searchBooks


import com.google.gson.annotations.SerializedName

import java.io.Serializable

data class Book(

    @SerializedName("title")
    val title: String?,

    @SerializedName("author_name")
    val author: List<String>?,

    @SerializedName("cover_i")
    val coverId: Int?,

    @SerializedName("first_publish_year")
    val publishYear: Int?,

    @SerializedName("subject")
    val subjects: List<String>?,

    @SerializedName("edition_count")
    val editionCount: Int?

) : Serializable