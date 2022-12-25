package com.example.lab3navigationlab.adapter


import android.annotation.SuppressLint
import android.app.DirectAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab3navigationlab.R
import com.example.lab3navigationlab.model.FilmModel
import com.example.lab3navigationlab.sreens.FilmsListFragment
import kotlinx.android.synthetic.main.film_item.view.*
import kotlinx.android.synthetic.main.fragment_description.view.*
import kotlinx.android.synthetic.main.fragment_list.view.*


class FilmAdapter(private val context: FilmsListFragment) :RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    private var filmsList = emptyList<FilmModel>()

    class FilmViewHolder(view: View):RecyclerView.ViewHolder(view){
        var image: ImageView

        init {
            this.image = itemView.findViewById(R.id.film_image)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {

        holder.itemView.film_name.text = filmsList[position].name
        Glide.with(context).load(filmsList[position].image).into(holder.image)

        val bundle = bundleOf("description" to filmsList[position].description)
        holder.itemView.setOnClickListener{view-> view.findNavController().navigate(R.id.main_nav2,bundle)}


    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<FilmModel>){
        filmsList = list
        notifyDataSetChanged()
    }
}