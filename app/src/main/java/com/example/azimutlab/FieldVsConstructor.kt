package com.example.azimutlab

import com.example.azimutlab.mvvm.repository.MainRepositoryImpl
import javax.inject.Inject


//constructor injection
//class FieldVsConstructor @Inject constructor(var mainRepos: MainRepositoryImpl){
    //Annotate an @Provides method or injectable class with @Singleton.
    // The graph will use a single instance of the value for all of its clients.
    // It reminds potential maintainers that this class may be shared by multiple threads.
    

    //in my unit test i could simply add mainRepos without init DI
    /*
        var mockMainRepo = mock(MainRepository::class)
        var fvc = FieldVsConstructor(mockMainRepo)
     */
/*

   Field injection

   @Inject
    lateinit var mainRepo: MainRepository

    init {
        DaggerServiceComponent.builder()
            .appComponent(AzimutApp.getApplicationComponent())
            .build()
            .inject(this)
    }*/

//}