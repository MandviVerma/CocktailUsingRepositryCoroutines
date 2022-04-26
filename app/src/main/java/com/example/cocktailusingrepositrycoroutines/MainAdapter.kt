package com.example.cocktailusingrepositrycoroutines

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktailusingrepositrycoroutines.databinding.ItemBinding
import java.util.ArrayList

class MainAdapter(
    private var mContext: Context?,
    private var drinksData: List<Drink>
) : RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {
    private lateinit var binding: ItemBinding

    fun setData(drinks: ArrayList<Drink>) {
        this.drinksData = drinks
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding.root)
    }

     class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        if (position == 9) {
            binding.tvCategory.text = drinksData[position].strCategory

            val myInstruction: String =
                "Pour all ingredients into a cocktail shaker, mix and serve over ice into a chilled glass."
            binding.tvInstructions.text = myInstruction

        } else {
            binding.tvCategory.text = drinksData[position].strCategory
            binding.tvInstructions.text = drinksData[position].strInstructions
        }



        mContext?.let {
            Glide.with(it).load(drinksData[position].strDrinkThumb)
                .placeholder(R.drawable.ic_drink).into(binding.ivThumb)
        }

    }

    override fun getItemCount(): Int {
        return drinksData.size


    }

}