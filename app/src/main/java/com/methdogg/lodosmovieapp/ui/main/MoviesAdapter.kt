package com.methdogg.lodosmovieapp.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.methdogg.lodosmovieapp.R
import com.methdogg.lodosmovieapp.data.model.Movie

class MoviesAdapter(private val mContext: Context, private val list: List<Movie>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.list_item_movie, parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewMovie.text = list[position].title

        Glide.with(mContext).load(list[position].poster).into(holder.imageViewMovie)
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textViewMovie: AppCompatTextView = view.findViewById(R.id.textViewMovieName)
    val imageViewMovie: AppCompatImageView = view.findViewById(R.id.imageViewMovie)
}