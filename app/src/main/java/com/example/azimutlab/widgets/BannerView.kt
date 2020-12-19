package com.example.azimutlab.widgets

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.azimutlab.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.attr

class BannerView (context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    var bannerTitle: String? = null
        set(value) {
            
            tvTitle.text = value
        }

    var bannerDescription: String? = null
        set(value) {
            tvDescription.text = value
        }

    var bannerImagePath: String? = null
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

        setBannerTitle(attributes)
        setDescription(attributes)
        setImagePath(attributes)

        attributes.recycle()
    }


    private fun setBannerTitle(attributes: TypedArray) {
        bannerTitle =  if(isInEditMode && !attributes.hasValue(R.styleable.BannerView_bannerTitle)){
            "Title"
        } else {
            attributes.getString(R.styleable.BannerView_bannerTitle)
        }
    }

    private fun setImagePath(attributes: TypedArray) {
        if(attributes.hasValue(R.styleable.BannerView_bannerImagePath)){
            bannerImagePath = attributes.getString(R.styleable.BannerView_bannerImagePath)
        }
    }

    private fun setDescription(attributes: TypedArray) {
        bannerDescription =  if(isInEditMode && !attributes.hasValue(R.styleable.BannerView_bannerDescription)){
            "Description"
        } else {
            attributes.getString(R.styleable.BannerView_bannerDescription)
        }

    }
}