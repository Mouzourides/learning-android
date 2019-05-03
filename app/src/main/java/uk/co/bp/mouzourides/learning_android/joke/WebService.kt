package uk.co.bp.mouzourides.learning_android.joke

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import uk.co.bp.mouzourides.learning_android.joke.JokeData

interface WebService {
    @Headers(
        "Accept: application/json",
        "User-Agent: learning android development (https://github.com/mouzourides/learning-android)"
    )
    @GET("/")
    fun getJoke(): Call<JokeData>
}