package com.android.jetpacksub.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.jetpacksub.data.Tv
import com.android.jetpacksub.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var detailActivityBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailActivityBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailActivityBinding.root)

        val extras = intent.getParcelableExtra<Tv>(EXTRA_DATA)
        if (extras != null) {
            val nameTv = extras.name
            val desTvdetail = extras.desc
            val imgTvDetail = extras.img

            detailActivityBinding.textTitTv.text = nameTv.toString()
            detailActivityBinding.textDesTv.text = desTvdetail.toString()
            Glide.with(this)
                    .load(imgTvDetail)
                    .apply(RequestOptions().override(100, 100))
                    .into(detailActivityBinding.imageTv)

        }
    }

}
