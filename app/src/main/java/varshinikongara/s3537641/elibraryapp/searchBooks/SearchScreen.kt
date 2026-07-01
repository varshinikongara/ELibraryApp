package varshinikongara.s3537641.elibraryapp.searchBooks


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    viewModel: SearchViewModel = viewModel(),
    onViewDetails: (Book) -> Unit = {}
)
{

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text("Search Books")
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1565C0),
                    titleContentColor = Color.White
                )

            )

        }

    ) { paddingValues ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)

        ) {

            OutlinedTextField(

                value = uiState.searchQuery,

                onValueChange = {

                    viewModel.updateSearchQuery(it)

                },

                modifier = Modifier.fillMaxWidth(),

                placeholder = {

                    Text("Search by title, author...")

                },

                leadingIcon = {

                    Icon(Icons.Default.Search, null)

                },

                singleLine = true

            )

            Button(

                onClick = {

                    viewModel.searchBooks()

                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)

            ) {

                Text("Search")

            }

            when {

                uiState.isLoading -> {

                    Column(

                        modifier = Modifier.fillMaxSize(),

                        horizontalAlignment = Alignment.CenterHorizontally,

                        verticalArrangement = Arrangement.Center

                    ) {

                        CircularProgressIndicator()

                        Text(

                            text = "Searching books...",

                            modifier = Modifier.padding(top = 16.dp)

                        )

                    }

                }

                uiState.errorMessage != null -> {

                    Column(

                        modifier = Modifier.fillMaxSize(),

                        horizontalAlignment = Alignment.CenterHorizontally,

                        verticalArrangement = Arrangement.Center

                    ) {

                        Text(

                            text = uiState.errorMessage!!,

                            color = MaterialTheme.colorScheme.error

                        )

                    }

                }

                uiState.books.isEmpty() -> {

                    Column(

                        modifier = Modifier.fillMaxSize(),

                        horizontalAlignment = Alignment.CenterHorizontally,

                        verticalArrangement = Arrangement.Center

                    ) {

                        Text(

                            text = "Search your favourite books 📚"

                        )

                    }

                }

                else -> {

                    LazyColumn(

                        modifier = Modifier.fillMaxSize(),

                        contentPadding = PaddingValues(top = 16.dp),

                        verticalArrangement = Arrangement.spacedBy(12.dp)

                    ) {

                        items(uiState.books) { book ->

                            BookItem(

                                book = book,

                                onViewDetails = {

                                    onViewDetails(book)

                                }

                            )

                            HorizontalDivider()

                        }

                    }

                }

            }

        }

    }

}