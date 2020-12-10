package com.example.azimutlab.widgets

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.azimutlab.R
import com.squareup.picasso.Picasso

class BannerView (context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    var bannerTitle: String? = null
        set(value) {
            tvTitle.text = value
        }

    var bannerDescription: String? = null
        set(value) {
            tvDescription.text = value
        }

    var imagePath: String? = null
        set(value) {
            Picasso.get()
                .load(value)
                .into(image)
        }

    private var attributes: TypedArray
    private var tvTitle: TextView
    private var tvDescription: TextView
    private var image: ImageView

    init {
        inflate(context, R.layout.view_banner, this)

        tvTitle = findViewById(R.id.view_banner_title)
        tvDescription = findViewById(R.id.view_banner_description)
        image = findViewById(R.id.view_banner_image)

        attributes = context.obtainStyledAttributes(attrs, R.styleable.BannerView)

        bannerTitle =  if(!isInEditMode){
            attributes.getString(R.styleable.BannerView_bannerTitle)
        } else {
            "Title"
        }

        bannerDescription =  if(!isInEditMode){
            attributes.getString(R.styleable.BannerView_bannerDescription)
        } else {
            "Description"
        }

        if(!isInEditMode){
            imagePath = attributes.getString(R.styleable.BannerView_bannerDescription)
        } else {

        }


        attributes.recycle()
    }
}