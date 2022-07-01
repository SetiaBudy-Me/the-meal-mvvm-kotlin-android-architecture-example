package com.l3udy.themeal.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.l3udy.themeal.R
import com.l3udy.themeal.data.model.MealCategory
import com.l3udy.themeal.view.ui.MealCategoryActivity
import kotlinx.android.synthetic.main.item_category.view.*
import org.json.JSONObject

class MealCategoriesAdapter(private val items: ArrayList<MealCategory>) : RecyclerView.Adapter<MealCategoriesAdapter.DataViewHolder>() {

    class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(mealCategory: MealCategory) {
            with(view) {
                Glide.with(context)
                    .load(mealCategory.thumb)
                    .into(ivThumb)

                tvCategoryName.text = mealCategory.name
                tvDescription.text = mealCategory.description

                setOnClickListener {
                    val data = JSONObject()
                    data.put("name", mealCategory.name)
                    data.put("thumb", mealCategory.thumb)
                    data.put("description", mealCategory.description)

                    val intent = Intent(context, MealCategoryActivity::class.java)
                    intent.putExtra("data", data.toString())
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addData(list: List<MealCategory>) {
        items.addAll(list)
    }
}