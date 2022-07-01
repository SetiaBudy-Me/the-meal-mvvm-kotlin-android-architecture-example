package com.l3udy.themeal.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.l3udy.themeal.R
import com.l3udy.themeal.data.model.Meal
import com.l3udy.themeal.view.ui.MealDetailsActivity
import kotlinx.android.synthetic.main.item_meal.view.*

class MealsAdapter(private val items: ArrayList<Meal>) : RecyclerView.Adapter<MealsAdapter.DataViewHolder>() {

    class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(meal: Meal) {
            with(view) {
                Glide.with(context)
                    .load(meal.thumb)
                    .into(ivThumb)

                tvName.text = meal.name

                setOnClickListener {
                    val intent = Intent(context, MealDetailsActivity::class.java)
                    intent.putExtra("id", meal.id)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addData(list: List<Meal>) {
        items.addAll(list)
    }
}