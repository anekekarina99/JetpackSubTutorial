package com.android.jetpacksub.ui.movieTv.tv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.jetpacksub.data.Tv
import com.android.jetpacksub.databinding.FragmentTvBinding
import com.android.jetpacksub.ui.detail.DetailActivity


class TvFragment : Fragment() {


    private lateinit var fragmentTvBinding: FragmentTvBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentTvBinding = FragmentTvBinding.inflate(inflater, container, false)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvViewModel::class.java]
            val Tv = viewModel.getTv()

            val tvAdapter = TvAdapter()
            tvAdapter.setTv(Tv)


            with(fragmentTvBinding.recyclerViewTv) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                fragmentTvBinding.recyclerViewTv.adapter = tvAdapter

                tvAdapter.setOnItemClickCallback(
                        object : TvAdapter.OnItemClickCallback {
                            override fun onItemClicked(data: Tv) {
                                showSelectedKontak(data)
                            }
                        })
            }
        }
    }


    private fun showSelectedKontak(data: Tv) {
        Toast.makeText(context, "Kamu memilih ${data.name}", Toast.LENGTH_SHORT).show()
        val user = Tv(
                data.img,
                data.name,
                data.desc,
        )
        val i = Intent(activity, DetailActivity::class.java)
        i.putExtra(DetailActivity.EXTRA_DATA, user)
        activity?.startActivity(i)

    }
}


