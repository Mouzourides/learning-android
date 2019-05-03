package uk.co.bp.mouzourides.learning_android.joke

import android.arch.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Singleton
class JokeRepository {

    fun getJokeData(): MutableLiveData<JokeData> {
        val data = MutableLiveData<JokeData>()
        val gson = Gson()
        val service = Retrofit.Builder()
            .baseUrl("https://icanhazdadjoke.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create<WebService>(WebService::class.java)

        service.getJoke().enqueue(object : Callback<JokeData> {
            override fun onResponse(call: Call<JokeData>, response: Response<JokeData>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<JokeData>, t: Throwable) {
                data.value = JokeData("-1", "Joke not found", 404)
            }
        })

        return data
    }
}


data class JokeData(val id: String, val joke: String, val status: Int)