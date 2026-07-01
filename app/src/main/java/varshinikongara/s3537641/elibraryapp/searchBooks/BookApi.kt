package varshinikongara.s3537641.elibraryapp.searchBooks


import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {

    @GET("search.json")
    suspend fun searchBooks(

        @Query("q")
        query: String

    ): BookSearchResponse

}