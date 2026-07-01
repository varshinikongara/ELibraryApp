package varshinikongara.s3537641.elibraryapp.searchBooks




class BookRepository {

    suspend fun searchBooks(
        query: String
    ): Result<List<Book>> {

        return try {

            val response = RetrofitInstance.api.searchBooks(query)

            Result.success(response.books)

        } catch (e: Exception) {

            Result.failure(e)

        }

    }

}