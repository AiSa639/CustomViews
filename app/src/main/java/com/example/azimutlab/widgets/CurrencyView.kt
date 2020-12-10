package com.example.azimutlab.widgets

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.example.azimutlab.R

class CurrencyView (context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    var isMultiCurrency: Boolean? = null
    set(value) {
        if(value == false){
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_bottom, 0);
        }
    }

    var currencyType: String? = null
    set(value) {
        textView.text = value
    }

    private var attributes: TypedArray
    private var textView: TextView

    init {
        inflate(context, R.layout.view_currency_state, this)

        textView = findViewById(R.id.item_currency_state_text)
        attributes = context.obtainStyledAttributes(attrs, R.styleable.CurrencyView)

        currencyType =  if(!isInEditMode){
            attributes.getString(R.styleable.CurrencyView_currencyType)
        } else {
            "〒"
        }

        isMultiCurrency =  if(!isInEditMode){
            attributes.getBoolean(R.styleable.CurrencyView_isMultiCurrency, false)
        } else {
            true
        }


        attributes.recycle()
    }
}