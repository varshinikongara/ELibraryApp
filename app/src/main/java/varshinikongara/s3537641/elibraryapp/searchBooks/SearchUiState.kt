package varshinikongara.s3537641.elibraryapp.searchBooks



data class SearchUiState(

    val searchQuery: String = "",

    val books: List<Book> = emptyList(),

    val isLoading: Boolean = false,

    val errorMessage: String? = null

)