package com.example.azimutlab.koin

import com.example.azimutlab.mvvm.viewmodels.ViewModelTestKoin
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module


val viewModelModule = module {
   viewModel {
       ViewModelTestKoin(get())
   }
}
