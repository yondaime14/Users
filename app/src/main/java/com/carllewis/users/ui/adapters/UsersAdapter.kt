package com.carllewis.users.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carllewis.users.databinding.ItemUserBinding
import com.carllewis.users.datamodels.Users
import com.carllewis.users.utils.IMG_URL
import com.squareup.picasso.Picasso

class UsersAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var users = mutableListOf<Users>()

    fun setUserlist(users: List<Users>) {

        this.users = users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
       val user = users[position]

        holder.binding.userName.text = user.name
        holder.binding.userEmail.text = user.email
        Picasso.get().load(IMG_URL).into(holder.binding.userAvatarImg)
        holder.binding.userID.text = user.id.toString()
    }

    override fun getItemCount() = users.size


}

class MainViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){}