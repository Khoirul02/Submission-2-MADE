package com.huda.submission_2_made

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_data.view.*

class ListTvShowAdapter (private val listTvShow: ArrayList<RootData>) : RecyclerView.Adapter<ListTvShowAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i : Int
    ): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_data, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listTvShow.size
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (tvShow: RootData){
            with(itemView){
                Glide.with(itemView.context)
                    .load(tvShow.photo)
                    .apply(RequestOptions().override(512, 512))
                    .into(img_item_photo)
                tv_item_name.text = tvShow.name
                tv_item_description.text = tvShow.description
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(tvShow) }
            }
        }
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listTvShow[position])
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: RootData)
    }

}