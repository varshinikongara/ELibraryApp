package varshinikongara.s3537641.elibraryapp.searchBooks


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL =
        "https://openlibrary.org/"

    val api: BookApi by lazy {

        Retrofit.Builder()

            .baseUrl(BASE_URL)

            .addConverterFactory(
                GsonConverterFactory.create()
            )

            .build()

            .create(BookApi::class.java)

    }

}