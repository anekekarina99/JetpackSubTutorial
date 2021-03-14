package com.android.jetpacksub.ui.movieTv.tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.jetpacksub.R
import com.android.jetpacksub.data.Tv
import com.android.jetpacksub.databinding.ItemTvBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvAdapter : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {
    private var tv = ArrayList<Tv>()

    fun setTv(courses: List<Tv>?) {
        if (courses == null) return
        this.tv.clear()
        this.tv.addAll(courses)
    }

    private var onItemClickCallback:  OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tv, parent, false)
        return TvViewHolder(mView)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bind(tv[position])
    }

    override fun getItemCount() = tv.size

    inner class TvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemTvBinding.bind(itemView)
        fun bind(movieek: Tv) {
            binding.textTitTv.text = movieek.name
            binding.textDesTv.text = movieek.desc
            Glide.with(itemView.context)
                .load(movieek.img)
                .apply(RequestOptions().override(55, 55))
                .into(binding.imageTv)


            itemView.setOnClickListener {
                onItemClickCallback?.onItemClicked(movieek)

            }
        }
    }
}