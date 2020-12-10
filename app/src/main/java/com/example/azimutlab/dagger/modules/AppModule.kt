package com.example.azimutlab.dagger.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.azimutlab.helpers.PreferenceHelper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//@Module
//class AppModule(var context: Context, var baseUrl: String) {
//
//
//    @Provides
//    fun context(): Context {
//        return context
//    }
//
//    // here create retrofit
//    @Provides
//    fun retrofitBuild(okHttpClient: OkHttpClient, provideRxAdapter: RxJava2CallAdapterFactory):
//            Retrofit {
//        return Retrofit.Builder()
//            .addCallAdapterFactory(provideRxAdapter)
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(baseUrl)
//            .client(okHttpClient)
//            .build()
//    }
//
//
//    @Provides
//    fun provideRxAdapter(): RxJava2CallAdapterFactory {
//        return RxJava2CallAdapterFactory.create()
//    }
//
//    @Provides
//    fun provideSharedPref(context: Context): SharedPreferences {
//        return PreferenceManager.getDefaultSharedPreferences(context)
//    }


//}