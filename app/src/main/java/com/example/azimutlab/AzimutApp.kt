package com.example.azimutlab

import android.app.Activity
import android.app.Application
import androidx.multidex.MultiDexApplication
import com.example.azimutlab.Constants.BASE_URL
import com.example.azimutlab.koin.appModule
import com.example.azimutlab.koin.repoModule
import com.example.azimutlab.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class AzimutApp : MultiDexApplication() {


    companion object {
        fun get(activity: Activity): AzimutApp {
            return activity.application as AzimutApp
        }


        //koin for inject
        lateinit var koinTest: Koin



    }

    override fun onCreate() {
        super.onCreate()
//        createAppComponent()
//        createServiceComponent()
        //create koin for injection
        koinTest = startKoin {
            androidContext(this@AzimutApp)
            modules(listOf(appModule, repoModule, viewModelModule))
        }.koin
    }

//    private fun createAppComponent() {
//        appComponent = DaggerAppComponent
//            .builder()
//            .appModule(AppModule(this, BASE_URL))
//            .build()
//    }
//
//    private fun createServiceComponent() {
//        serviceComponent = DaggerServiceComponent
//            .builder()
//            .appComponent(appComponent)
//            .build()
//    }

}