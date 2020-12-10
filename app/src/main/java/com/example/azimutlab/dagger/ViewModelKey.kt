package com.example.azimutlab.dagger

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

//Для начала создадим то, что у нас будет ключом, логично для этого использовать класс модели.
//@MustBeDocumented
//@Target(AnnotationTarget.FUNCTION,
//    AnnotationTarget.PROPERTY_GETTER,
//    AnnotationTarget.PROPERTY_SETTER)
//@Retention(AnnotationRetention.RUNTIME)
//@MapKey
//annotation class ViewModelKey(val value: KClass<out ViewModel>)