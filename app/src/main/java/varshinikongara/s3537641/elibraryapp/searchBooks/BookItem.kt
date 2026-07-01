package varshinikongara.s3537641.elibraryapp.searchBooks


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun BookItem(
    book: Book,
    onViewDetails: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        ) {

            if (book.coverId != null) {

                AsyncImage(

                    model = "https://covers.openlibrary.org/b/id/${book.coverId}-L.jpg",

                    contentDescription = book.title,

                    modifier = Modifier
                        .width(110.dp)
                        .height(160.dp),

                    contentScale = ContentScale.Crop

                )

            } else {

                Box(

                    modifier = Modifier
                        .width(110.dp)
                        .height(160.dp)
                        .background(Color(0xFFE3F2FD)),

                    contentAlignment = Alignment.Center

                ) {

                    Icon(

                        imageVector = Icons.Default.Person,

                        contentDescription = null,

                        tint = Color(0xFF1565C0),

                        modifier = Modifier.size(48.dp)

                    )

                }

            }

            Column(

                modifier = Modifier
                    .weight(1f)
                    .height(160.dp),

                verticalArrangement = Arrangement.SpaceBetween

            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(

                        text = book.title ?: "Unknown Title",

                        style = MaterialTheme.typography.titleMedium,

                        fontWeight = FontWeight.Bold,

                        maxLines = 2,

                        overflow = TextOverflow.Ellipsis

                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(

                        text = "Author",

                        style = MaterialTheme.typography.labelMedium,

                        color = Color.Gray

                    )

                    Text(

                        text = book.author?.joinToString(", ")
                            ?: "Unknown",

                        style = MaterialTheme.typography.bodyMedium,

                        maxLines = 1,

                        overflow = TextOverflow.Ellipsis

                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(

                        text = "Published : ${book.publishYear ?: "-"}",

                        style = MaterialTheme.typography.bodySmall

                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(

                        text = "Category : ${
                            book.subjects
                                ?.take(2)
                                ?.joinToString(", ")
                                ?: "N/A"
                        }",

                        style = MaterialTheme.typography.bodySmall,

                        maxLines = 2,

                        overflow = TextOverflow.Ellipsis

                    )

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 12.dp
                        ),
                    horizontalArrangement = Arrangement.End
                ) {

                    Button(
                        onClick = onViewDetails
                    ) {

                        Text("View Details")

                    }

                }

            }

        }

    }

}