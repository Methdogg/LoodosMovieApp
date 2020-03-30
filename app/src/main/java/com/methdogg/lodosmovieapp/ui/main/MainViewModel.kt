package com.methdogg.lodosmovieapp.ui.main

import androidx.lifecycle.MutableLiveData
import com.methdogg.lodosmovieapp.base.BaseViewModel
import com.methdogg.lodosmovieapp.data.model.Movie
import com.methdogg.lodosmovieapp.network.service.MovieService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var movieService: MovieService

    val movies = MutableLiveData<List<Movie>>()

    val loadingState = MutableLiveData<Boolean>()

    override fun start() = Unit

    override fun stop() {
        disposable.dispose()
    }

    fun getMovies(searchQuery: String) {
        when (searchQuery.isNotEmpty()) {
            true -> {
                loadingState.value = true

                disposable = movieService.getMovies(searchQuery = searchQuery)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doAfterTerminate {
                        loadingState.value = false
                    }
                    .subscribe { response ->
                        if (response.isResponseSuccess == "True")
                            movies.value = response.searchList
                        else
                            movies.value = emptyList()
                    }
            }
        }
    }

}