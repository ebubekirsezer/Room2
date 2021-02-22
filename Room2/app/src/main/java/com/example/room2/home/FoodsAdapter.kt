package com.example.room2.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.room2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_row_home.view.*

class FoodsAdapter: RecyclerView.Adapter<FoodsAdapter.FoodsViewHolder>() {
    inner class FoodsViewHolder(itemView:View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Yemekler>(){
        override fun areItemsTheSame(oldItem: Yemekler, newItem: Yemekler):Boolean {
            return oldItem.yemek_adi==newItem.yemek_adi
        }

        override fun areContentsTheSame(oldItem: Yemekler, newItem: Yemekler): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsViewHolder {
       return FoodsViewHolder(
           LayoutInflater.from(parent.context).inflate(
               R.layout.custom_row_home,
               parent,false
           )
       )
    }


    override fun onBindViewHolder(holder: FoodsViewHolder, position: Int) {
        val food =differ.currentList[position]
        holder.itemView.apply{
            val url="http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
            Picasso.get().load(url).into(yemekResim)
            yemekAdi.text=food.yemek_adi
            Fiyat.text=food.yemek_fiyat+" TL"
            setOnClickListener{
                OnItemClickListener?.let { it(food)}
            }
        }
    }
    private var OnItemClickListener: ((Yemekler) -> Unit)?=null

    fun setOnItemClickListener(listener: (Yemekler)-> Unit){
        OnItemClickListener =listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}