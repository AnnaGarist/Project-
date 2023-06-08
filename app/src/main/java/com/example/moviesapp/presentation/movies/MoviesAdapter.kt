package com.example.moviesapp.presentation.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.model.Result

class MoviesAdapter(private val mList: List<Result>?, private val navController: NavController) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var titleTextView: TextView
        var ratingTextView: TextView
        var releaseDateTextView: TextView
        var root: LinearLayout

        init {
            imageView = itemView.findViewById(R.id.image)
            titleTextView = itemView.findViewById(R.id.title)
            ratingTextView = itemView.findViewById(R.id.rating)
            releaseDateTextView = itemView.findViewById(R.id.release_date)
            root = itemView.findViewById(R.id.root)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = mList!![position].title
        holder.ratingTextView.text = mList[position].voteAverage.toString()
        holder.releaseDateTextView.text = mList[position].releaseDate
        Glide.with(holder.imageView.context).load("https://image.tmdb.org/t/p/w500" + mList[position].posterPath)
            .into(holder.imageView)

        holder.root.setOnClickListener {
            navController.navigate(MoviesFragmentDirections.actionMoviesFragmentToDetailsFragment(mList!![position]))
        }
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }
}