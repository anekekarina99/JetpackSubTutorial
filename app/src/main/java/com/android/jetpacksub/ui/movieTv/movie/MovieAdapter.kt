package com.android.jetpacksub.ui.movieTv.movie


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.jetpacksub.R
import com.android.jetpacksub.data.Movie
import com.android.jetpacksub.databinding.ItemMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movie = ArrayList<Movie>()


    fun setMovie(courses: List<Movie>?) {
        if (courses == null) return
        this.movie.clear()
        this.movie.addAll(courses)
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val mView =
                LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(mView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movie[position])
    }

    override fun getItemCount() = movie.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Movie)
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMovieBinding.bind(itemView)
        fun bind(movieek: Movie) {
            binding.textTitM.text = movieek.name
            binding.textDesM.text = movieek.desc
            Glide.with(itemView.context)
                    .load(movieek.img)
                    .apply(RequestOptions().override(55, 55))
                    .into(binding.imageM)

            itemView.setOnClickListener {
                onItemClickCallback?.onItemClicked(movieek)

            }

        }
    }
}