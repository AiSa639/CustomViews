package com.example.azimutlab.dagger

import android.os.Bundle
import com.example.azimutlab.dagger.modules.BaseScreen
import javax.inject.Inject

class SberScreen  : BaseScreen() {
    companion object {
        fun getScreen(someId: Int): BaseScreen = SberScreen()
    }

    fun getId() = 2

    fun newInstance(screenId: Int? = null): SberScreen{
        return SberScreen()
    }

    fun getNameScreen() = "SberScreen returned"
    fun getScreen(screenId: Int) =
        when (screenId) {
            1 -> {
                "Some screen"
            }
            else -> "error"
        }

}