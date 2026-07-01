package varshinikongara.s3537641.elibraryapp.searchBooks


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(

    private val repository: BookRepository = BookRepository()

) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())

    val uiState: StateFlow<SearchUiState> =
        _uiState.asStateFlow()

    fun updateSearchQuery(query: String) {

        _uiState.value = _uiState.value.copy(
            searchQuery = query
        )

    }

    fun searchBooks() {

        val query = _uiState.value.searchQuery.trim()

        if (query.isEmpty()) {

            _uiState.value = _uiState.value.copy(
                books = emptyList(),
                errorMessage = null
            )

            return

        }

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = true,
                errorMessage = null
            )

            repository.searchBooks(query)

                .onSuccess { books ->

                    _uiState.value = _uiState.value.copy(
                        books = books,
                        isLoading = false,
                        errorMessage = if (books.isEmpty())
                            "No books found."
                        else
                            null
                    )

                }

                .onFailure { exception ->

                    _uiState.value = _uiState.value.copy(
                        books = emptyList(),
                        isLoading = false,
                        errorMessage = exception.localizedMessage
                            ?: "Something went wrong."
                    )

                }

        }

    }

}