package com.example.azimutlab.custom_errors

import com.example.azimutlab.AzimutApp
import com.example.azimutlab.R
import java.io.IOException

class NoConnectivityException : IOException() {
    //val context = AzimutApp.getApplicationComponent().getContext()
    override val message: String
        get() =
            "dfdfdf"
}

class NoInternetException() : IOException() {
    //val context = AzimutApp.getApplicationComponent().getContext()
    override val message: String
        get() =
            "sdsdsdsd"
}