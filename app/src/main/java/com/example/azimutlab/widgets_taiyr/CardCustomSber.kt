package com.example.azimutlab.widgets_taiyr

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.azimutlab.R

class CardCustomSber : LinearLayout {

    var cardTitleText: String?
        get() = cardTitle.text.toString()
        set(value) {
            if (value == null) {
                cardTitle.visibility = View.GONE
            } else {
                cardTitle.visibility = View.VISIBLE
                cardTitle.text = value
            }

        }

    var hintTitleText: String?
        get() = hintTitle.text.toString()
        set(value) {
            if (value == null) {
                hintTitle.visibility = View.GONE
            } else {
                if(cardTitleText.isNullOrBlank() && moneyText.isNullOrBlank()){
                    Log.d("here", "hintTyle view")
                    hintTitle.visibility = View.VISIBLE
                    hintTitle.apply {
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, spToPx(17f).toFloat())
                    }

                    hintTitle.text = value
                    cardImage.setImageResource(R.drawable.ic_hint_card)
                } else {
                    hintTitle.visibility = View.VISIBLE
                    hintTitle.text = value
                }
            }
        }
    var nameAdditionalText: String?
        get() = nameAdditional.text.toString()
        set(value) {
            if (value == null) {
                nameAdditional.visibility = View.GONE
            } else {
                nameAdditional.visibility = View.VISIBLE
                nameAdditional.text = value
            }
        }

    var moneyText: String?
        get() = moneySum.text.toString()
        set(value) {
            if (value == null) {
                moneySum.visibility = View.GONE
            } else {
                moneySum.visibility = View.VISIBLE
                moneySum.text = value
            }

        }

    var errorTextMsg: String?
        get() = errorText.text.toString()
        set(value) {
            if (value == null) {
                errorText.visibility = View.GONE
            } else {
                errorText.visibility = View.VISIBLE
                errorText.text = value
            }
        }

    var hasDivider: Boolean
        get() = divider.visibility == View.VISIBLE
        set(value) {
            if (value) {
                divider.visibility = View.VISIBLE
            } else {
                divider.visibility = View.GONE
            }
        }


    private lateinit var hintTitle: TextView
    private lateinit var errorText: TextView
    private lateinit var cardTitle: TextView
    private lateinit var cardHintInfo: TextView
    private lateinit var moneySum: TextView
    private lateinit var divider: View
    private lateinit var mainContainer: ConstraintLayout
    private lateinit var cardImage: ImageView
    private lateinit var arrowImage: ImageView
    private lateinit var mainLayout: LinearLayout
    private lateinit var nameAdditional: TextView

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        init(context)
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.CardCustomSber
        )
        cardTitle.text = typedArray.getText(R.styleable.CardCustomSber_titleCard)
        hintTitle.apply {
            if (typedArray.getBoolean(R.styleable.CardCustomSber_hasHintTitle, false)) {
                visibility = View.VISIBLE
                text = typedArray.getText(R.styleable.CardCustomSber_hintTitle)
            } else {
                visibility = View.GONE
            }
        }
        errorText.apply {
            if (typedArray.getBoolean(R.styleable.CardCustomSber_hasError, false)) {
                visibility = View.VISIBLE
                text = typedArray.getText(R.styleable.CardCustomSber_errorTitle)
                setTextColor(
                    typedArray.getColor(
                        R.styleable.CardCustomSber_errorColor,
                        ResourcesCompat.getColor(resources, R.color.colorError, null)
                    )
                )
            }
        }
        divider.apply {
            visibility = if (typedArray.getBoolean(R.styleable.CardCustomSber_hasDivider, false))
                View.VISIBLE else View.GONE
        }
        cardImage.apply {
            setImageDrawable(
                typedArray.getDrawable(
                    R.styleable.CardCustomSber_cardImage
                )
            )
        }
        arrowImage.apply {
            visibility = if (typedArray.getBoolean(
                    R.styleable.CardCustomSber_hasArrow,
                    true
                )
            ) View.VISIBLE else View.GONE

        }
        moneySum.apply {
            text = typedArray.getText(R.styleable.CardCustomSber_moneySum)
        }
        nameAdditional.text = typedArray.getText(R.styleable.CardCustomSber_additionalInfo)

        typedArray.recycle()
    }

    private fun init(context: Context) {
        inflate(context, R.layout.card_custom_widget, this)
        hintTitle = findViewById(R.id.hintTitle)
        errorText = findViewById(R.id.errorText)
        cardTitle = findViewById(R.id.title_card)
        cardHintInfo = findViewById(R.id.hintTitle)
        moneySum = findViewById(R.id.moneySum)
        mainContainer = findViewById(R.id.mainContent)
        mainLayout = findViewById(R.id.mainLayout)
        arrowImage = findViewById(R.id.arrow_down)
        cardImage = findViewById(R.id.cardIcon)
        nameAdditional = findViewById(R.id.nameAdditional)
        divider = findViewById(R.id.divider)

    }


    fun setCardImage(resId: Int = R.drawable.ic_card_2) {
        cardImage.visibility = View.VISIBLE
        cardImage.setImageResource(resId)
    }

    fun setClick(function: () -> Unit) {
        mainLayout.setOnClickListener {
            function()
        }
    }

}