package varshinikongara.s3537641.elibraryapp.searchBooks


import com.google.gson.annotations.SerializedName

data class BookSearchResponse(

    @SerializedName("docs")
    val books: List<Book>

)