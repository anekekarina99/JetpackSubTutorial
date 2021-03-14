package com.android.jetpacksub.ui.movieTv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.jetpacksub.databinding.ActivityMovietvBinding

class MovieTvActivity : AppCompatActivity(){
    private lateinit var tvMovieB : ActivityMovietvBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       tvMovieB = ActivityMovietvBinding.inflate(layoutInflater)
        setContentView(tvMovieB.root)

        val sectionsPagerAdapter = MovieTvAdapter(this, supportFragmentManager)
        tvMovieB.viewPagerOne.adapter = sectionsPagerAdapter
        tvMovieB.tabsOne.setupWithViewPager(tvMovieB.viewPagerOne)
        supportActionBar?.elevation = 0f
    }

}
