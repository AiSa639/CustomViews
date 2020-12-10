package com.example.azimutlab.mvvm.view.activities

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.azimutlab.R
import com.example.azimutlab.adapters.DataListAdapter
import com.example.azimutlab.helpers.toast
import com.example.azimutlab.hide
import com.example.azimutlab.mvvm.models.PostModel
import com.example.azimutlab.mvvm.viewmodels.ViewModelTestKoin
import com.example.azimutlab.show
import com.example.azimutlab.widgets.BannerView
import com.example.azimutlab.widgets.CurrencyView
import com.example.azimutlab.widgets_taiyr.CardCustomSber
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), LifecycleOwner {


    // Ссылка на viewModel, изменение состояния через подписку LiveData а не через колбек
    // в ВьюМоделе нужно ссылку на репозиторий и все возвращаемое оборачивать в обсервабле
    // BindingData dependencу с вьюшкой хмл
    //provide viewModel factory

    private var adapter = DataListAdapter()
    lateinit var recyclerView:RecyclerView

    private lateinit var currencyState: CurrencyView
    private lateinit var bannerView: BannerView
    lateinit var sberCard: CardCustomSber
    lateinit var sberCardHint: CardCustomSber


//    init {
//        DaggerServiceComponent.builder()
//            .appComponent(AzimutApp.appComponent)
//            .build()
//            .inject(this)
//    }


    private val mainViewModel : ViewModelTestKoin by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()

        launch.setOnClickListener {
            launch.hide()
            getList()
        }

        currencyState = findViewById(R.id.currency)
        bannerView = findViewById(R.id.banner_view)

        currencyState.isMultiCurrency = true
        currencyState.currencyType = "〒"

        bannerView.bannerDescription = "До 1 200 000 ₽\u2028на любые цели"
        bannerView.bannerTitle = "Кредит"
        bannerView.imagePath = "https://cis.visa.com/dam/VCOM/regional/ap/taiwan/global-elements/images/tw-visa-gold-card-498x280.png"


    }

    override fun onPause() {
        super.onPause()
        launch.show()
        list_data.hide()
        progress_bar.hide()
    }

    @SuppressLint("ShowToast")
    private fun bindViews(){


        recyclerView = findViewById(R.id.list_data)
        recyclerView.layoutManager = LinearLayoutManager(this)
        sberCard = findViewById(R.id.sberCardOne)
        sberCardHint = findViewById(R.id.sberCardHint)

        sberCardHint.apply {
            cardTitleText = null
            nameAdditionalText = null
            setCardImage(R.drawable.ic_card_2)
            moneyText = null
            hintTitleText = "Счет зачисления"
            errorTextMsg = null
            hasDivider = false
            setClick {
                //ripple effect
                Toast.makeText(context, "click", Toast.LENGTH_LONG).show()
            }
        }

        sberCard.apply {
            cardTitleText = "VISA"
            hintTitleText = "Счет зачисления"
            nameAdditionalText = "•• 6789 • кредитная"
            setCardImage(R.drawable.ic_card_2)
            moneyText = "343434 T"

            errorTextMsg = "djkfdsjfn dsfgkslkfmd dksfnfndf"
            hasDivider = true
            setClick {
                println(" kuka click in activty")
                Toast.makeText(context, "click", Toast.LENGTH_LONG).show()
            }
        }

        mainViewModel.listPostLiveData.observe(this, Observer {
            adapter.addDataList(it as ArrayList<PostModel>)
            recyclerView.adapter = adapter
            recyclerView.show()
        })

        mainViewModel.error.observe(this, Observer {
            this.toast(it)
        })

        mainViewModel.isLoading.observe(this, Observer{
            if(it==false){
                progress_bar.hide()
            } else{
                progress_bar.show()
            }
        })
    }

    private fun getList(){
        mainViewModel.getData()

    }

}
