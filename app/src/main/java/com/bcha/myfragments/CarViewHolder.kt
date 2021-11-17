package com.bcha.myfragments

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun bind(car: Car) {
        val photoImageView: ImageView = itemView.findViewById(R.id.photo_imageview)
        val brandTextView: TextView = itemView.findViewById(R.id.brand_model_text_view)
        val engineTextView: TextView = itemView.findViewById(R.id.engine_text_view)
        val driveTextView: TextView = itemView.findViewById(R.id.drive_text_view)
        val miliageTextView: TextView = itemView.findViewById(R.id.miliage_text_view)
        val powerTextView: TextView = itemView.findViewById(R.id.power_text_view)
        photoImageView.setImageResource(car.photo)
        brandTextView.text = "${car.brand} ${car.model}"
        engineTextView.text = "двигатель: ${car.engine}"
        driveTextView.text = "привод: ${car.drive}"
        miliageTextView.text = "пробег: ${car.mileage}"
        powerTextView.text = "мощность: ${car.power} л.с."

    }
}