package com.android.jetpacksub.ui.movieTv.tv

import androidx.lifecycle.ViewModel
import com.android.jetpacksub.data.Tv
import com.android.jetpacksub.util.DataTvDummy

class TvViewModel : ViewModel() {

    fun getTv(): List<Tv> = DataTvDummy.generateDummyTv()
}