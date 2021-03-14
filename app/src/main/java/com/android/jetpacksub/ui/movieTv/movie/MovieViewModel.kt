package com.android.jetpacksub.ui.movieTv.movie

import androidx.lifecycle.ViewModel
import com.android.jetpacksub.data.Movie
import com.android.jetpacksub.util.DataMovieDummy

class MovieViewModel: ViewModel() {

    fun getMovie(): List<Movie> = DataMovieDummy.generateDummyMovie()
}