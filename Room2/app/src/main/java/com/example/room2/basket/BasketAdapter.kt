package com.example.room2.basket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.room2.R
import com.example.room2.home.Yemekler
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_row_basket.view.*
import kotlinx.android.synthetic.main.custom_row_home.view.*

class BasketAdapter: RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {

    inner class BasketViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<SepetYemekler>(){
        override fun areItemsTheSame(oldItem: SepetYemekler, newItem: SepetYemekler):Boolean {
            return oldItem.yemek_adi==newItem.yemek_adi
        }

        override fun areContentsTheSame(oldItem: SepetYemekler, newItem: SepetYemekler): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        return BasketViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_row_basket,
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val basket =differ.currentList[position]
        holder.itemView.apply{
            val url="http://kasimadalan.pe.hu/yemekler/resimler/${basket.yemek_resim_adi}"
            Picasso.get().load(url).into(sepet_satir_gorsel)
            sepet_satir_yazi.text=basket.yemek_adi
            sepet_adet.text=basket.yemek_fiyat+" TL"
            setOnClickListener{
                OnItemClickListener?.let { it(basket)}
            }
        }
    }
    private var OnItemClickListener: ((SepetYemekler) -> Unit)?=null

    fun setOnItemClickListener(listener: (SepetYemekler)-> Unit){
        OnItemClickListener =listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}