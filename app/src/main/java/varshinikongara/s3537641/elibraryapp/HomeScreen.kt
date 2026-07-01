package varshinikongara.s3537641.elibraryapp


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import varshinikongara.s3537641.elibraryapp.searchBooks.Book

data class Category(
    val name: String
)

//data class Book(
//    val title: String,
//    val author: String
//)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    var search by remember {
        mutableStateOf("")
    }

    val categories = listOf(
        Category("Science"),
        Category("Maths"),
        Category("History"),
        Category("English"),
        Category("Programming"),
        Category("Competitive")
    )

    val recentBooks = listOf(

        Book(
            title = "Physics Fundamentals",
            author = listOf("R.K Sharma"),
            coverId = null,
            publishYear = 2022,
            subjects = listOf("Physics", "Science"),
            editionCount = 3
        ),

        Book(
            title = "Java Programming",
            author = listOf("James Gosling"),
            coverId = null,
            publishYear = 2021,
            subjects = listOf("Programming", "Java"),
            editionCount = 5
        ),

        Book(
            title = "Indian History",
            author = listOf("Bipin Chandra"),
            coverId = null,
            publishYear = 2019,
            subjects = listOf("History"),
            editionCount = 2
        )

    )

    val recommendedBooks = listOf(

        Book(
            title = "Android Development",
            author = listOf("Google"),
            coverId = null,
            publishYear = 2024,
            subjects = listOf("Android", "Programming"),
            editionCount = 1
        ),

        Book(
            title = "Mathematics Vol-2",
            author = listOf("R.D Sharma"),
            coverId = null,
            publishYear = 2023,
            subjects = listOf("Mathematics"),
            editionCount = 4
        ),

        Book(
            title = "English Grammar",
            author = listOf("Wren & Martin"),
            coverId = null,
            publishYear = 2020,
            subjects = listOf("English"),
            editionCount = 8
        ),

        Book(
            title = "Data Structures",
            author = listOf("Mark Allen Weiss"),
            coverId = null,
            publishYear = 2022,
            subjects = listOf("Computer Science", "Programming"),
            editionCount = 6
        )

    )

    Scaffold(

        topBar = {

            TopAppBar(
                title = {
                    Text(
                        text = "E-Library",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1565C0),
                    titleContentColor = Color.White
                )
            )

        },

        bottomBar = {

            NavigationBar {

                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Home, null)
                    },
                    label = {
                        Text("Home")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("search")
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    },
                    label = {
                        Text("Search")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Person, null)
                    },
                    label = {
                        Text("Library")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Person, null)
                    },
                    label = {
                        Text("Profile")
                    }
                )

            }

        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),

            contentPadding = PaddingValues(16.dp),

            verticalArrangement = Arrangement.spacedBy(18.dp)

        ) {

            item {

                Text(
                    text = "Hello Student 👋",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Continue your learning journey.",
                    color = Color.Gray
                )

            }

            item {

                OutlinedTextField(

                    value = search,

                    onValueChange = {
                        search = it
                    },

                    modifier = Modifier.fillMaxWidth(),

                    leadingIcon = {
                        Icon(Icons.Default.Search, null)
                    },

                    placeholder = {
                        Text("Search books...")
                    },

                    shape = RoundedCornerShape(16.dp)

                )

            }

            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFE3F2FD)
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            "Reading Progress",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        LinearProgressIndicator(
                            progress = { 0.65f },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            "65% Completed"
                        )

                    }

                }

            }

            item {

                Text(
                    "Categories",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

            }

            item {

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(categories) { category ->

                        Card(
                            modifier = Modifier.clickable { },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF1565C0)
                            )
                        ) {

                            Row(
                                modifier = Modifier.padding(
                                    horizontal = 18.dp,
                                    vertical = 12.dp
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Icon(
                                    Icons.Default.Person,
                                    null,
                                    tint = Color.White
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                Text(
                                    category.name,
                                    color = Color.White
                                )

                            }

                        }

                    }

                }

            }

            item {

                Text(
                    "Recently Opened",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

            }

            items(recentBooks) { book ->

                BookCard(book)

            }

            item {

                Text(
                    "Recommended Books",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

            }

            items(recommendedBooks) { book ->

                BookCard(book)

            }

        }

    }

}

@Composable
fun BookCard(
    book: Book
) {

    Card(

        modifier = Modifier
            .fillMaxWidth(),

        shape = RoundedCornerShape(18.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )

    ) {

        Row(

            modifier = Modifier
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically

        ) {

            Box(

                modifier = Modifier
                    .size(65.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF1565C0)),

                contentAlignment = Alignment.Center

            ) {

                Icon(

                    Icons.Default.Person,

                    contentDescription = null,

                    tint = Color.White,

                    modifier = Modifier.size(32.dp)

                )

            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                book.title?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "book.author",
                    color = Color.Gray
                )

            }

            Box(

                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF4CAF50))

            )

        }

    }

}