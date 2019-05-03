package uk.co.bp.mouzourides.learning_android.joke

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

class JokeViewModel: ViewModel() {

//    @Inject
    private val jokeRepository: JokeRepository = JokeRepository()
    var joke: MutableLiveData<JokeData> = jokeRepository.getJokeData()

    fun refreshJoke(): MutableLiveData<JokeData> {
        return jokeRepository.getJokeData()
    }
}
