package com.example.azimutlab.dagger.components

import com.example.azimutlab.api.ApiService
import com.example.azimutlab.mvvm.repository.MainRepositoryImpl
import com.example.azimutlab.mvvm.view.activities.MainActivity
import dagger.Component

//@Component(modules = [ServiceModule::class, RepositoryModules::class], dependencies = [AppComponent::class])
//interface ServiceComponent {
//    fun inject(repository: MainRepositoryImpl)
//    fun inject(activity: MainActivity)
//   // fun inject(mainViewModel: MainViewModel)
//    fun getApiService():ApiService
//}