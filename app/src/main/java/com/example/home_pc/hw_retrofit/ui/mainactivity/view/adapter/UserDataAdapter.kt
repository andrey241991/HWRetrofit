package com.example.home_pc.hw_retrofit.ui.mainactivity.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.home_pc.hw_retrofit.R
import com.example.home_pc.hw_retrofit.ui.mainactivity.viewmodel.MainViewModel

class UserDataAdapter(var viewModel: MainViewModel) : RecyclerView.Adapter<UserDataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.user_data_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return viewModel.listItems.value?.size ?: return 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewModel.onBindRepositoryRowViewAtPosition(position, viewHolder)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            var cardView = itemView.findViewById<CardView>(R.id.card_view)
            cardView.setOnClickListener({ viewModel.onItemClicked(adapterPosition) })
        }

       val imgAvatar = itemView.findViewById<ImageView>(R.id.img_avatar)
       val txtLogin = itemView.findViewById<TextView>(R.id.txt_login)
       val txtId = itemView.findViewById<TextView>(R.id.txt_id)

        fun bindLogin(login:String) {
            txtLogin.text = login
        }

        fun bindId(id:String) {
            txtId.text = id
        }

        fun bindAvatar(avatar_url: String) {
            Glide.with(this.itemView.context)
                .load(avatar_url)
                .apply(RequestOptions.circleCropTransform())
                .into(imgAvatar);
        }

    }

}