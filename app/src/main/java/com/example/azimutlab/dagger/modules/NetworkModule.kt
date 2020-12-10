package com.example.azimutlab.dagger.modules

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.util.Log
import com.example.azimutlab.Constants
import com.example.azimutlab.helpers.NoInternetConnectInterceptor
import com.example.azimutlab.helpers.PreferenceHelper
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

//@Module
//class NetworkModule {
//
//    //check internet here
//    @Provides
//    fun interceptor(sharedPreferences: SharedPreferences, context:Context) :
//            Interceptor {
//        return Interceptor { chain ->
//            val request = chain.request().newBuilder()
//            val userToken = sharedPreferences.getString(Constants.TOKEN, "")
//            var versionApp = ""
//
//            try {
//                val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
//                versionApp = pInfo.versionName
//            } catch (e: PackageManager.NameNotFoundException) {
//                e.printStackTrace()
//            }
//
//            if (userToken != "") {
//                request.addHeader("auth-token", userToken!!)
//                Log.v("*************** Mine: ", "token is = $userToken")
//            }
//
//            request.addHeader("source", "android")
//            request.addHeader("version", versionApp)
//
//            chain.proceed(request.build())
//        }
//    }
//
//    @Provides
//    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.HEADERS
//        logging.level = HttpLoggingInterceptor.Level.BODY
//        return logging
//    }
//
//    //we can catch this exception in interceptor and call NoInternetConnection activity for example
//    @Provides
//    fun okHttpClient(
//        interceptor: Interceptor,
//        httpLoggingInterceptor: HttpLoggingInterceptor,
//        noInternetConnectInterceptor: NoInternetConnectInterceptor
//    ): OkHttpClient {
//        return OkHttpClient().newBuilder()
//            .connectTimeout(15, TimeUnit.SECONDS)
//            .readTimeout(15, TimeUnit.SECONDS)
//            .writeTimeout(15, TimeUnit.SECONDS)
//            .addInterceptor(httpLoggingInterceptor)
//            .addInterceptor(noInternetConnectInterceptor)
//            .addInterceptor(StethoInterceptor())
//            .addNetworkInterceptor(interceptor)
//            .build()
//    }
//
//    @Provides
//    fun internetConnectionInterceptor(context: Context): NoInternetConnectInterceptor {
//        return NoInternetConnectInterceptor(context)
//    }
//}