package com.example.azimutlab.mvvm.viewmodels
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.example.azimutlab.AzimutApp
//import com.example.azimutlab.custom_errors.NoInternetException
//import com.example.azimutlab.dagger.components.DaggerServiceComponent
//import com.example.azimutlab.mvvm.models.PostModel
//import com.example.azimutlab.mvvm.repository.MainRepositoryImpl
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.schedulers.Schedulers
//import java.lang.Exception
//import javax.inject.Inject
//
////reference to repository
//class MainViewModel @Inject constructor(
//    private val mainRepos: MainRepositoryImpl
//) : BaseViewModel() {
//
//
//    val listPostLiveData by lazy { MutableLiveData<List<PostModel>>() }
//    val isLoading by lazy { MutableLiveData<Boolean>() }
//    val error by lazy { MutableLiveData<Exception>() }
//
//    fun getData() {
//        isLoading.value = true
//        addDisposable(
//            mainRepos.getPosts()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    isLoading.value = false
//                    listPostLiveData.value = it
//                }, {
//                    isLoading.value = false
//                    error.value = it as Exception?
//                })
//        )
//    }
//
//}