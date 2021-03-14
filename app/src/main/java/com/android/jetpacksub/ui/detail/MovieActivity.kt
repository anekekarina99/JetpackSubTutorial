package com.android.jetpacksub.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.jetpacksub.data.Movie
import com.android.jetpacksub.databinding.ActivityMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        if (extras != null) {
            val nameMovie = extras.name
            val desMovie = extras.desc
            val imgMovie = extras.img

            binding.textTitMovie.text = nameMovie.toString()
            binding.textDesMovie.text = desMovie.toString()
            Glide.with(this)
                    .load(imgMovie)
                    .apply(RequestOptions().override(100, 100))
                    .into(binding.imageMovie)

        }
    }

}
