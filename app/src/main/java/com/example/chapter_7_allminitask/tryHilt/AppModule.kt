//package com.example.chapter_7_allminitask.tryHilt
//
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.internal.managers.ApplicationComponentManager
//import javax.inject.Named
//import javax.inject.Singleton
//
//@Module
//@InstallIn(ApplicationComponentManager::class)
//object AppModule {
//
//    @Singleton
//    @Provides
//    @Named("String1")
//    fun provideTestString1() = "This is a String we will inject"
//
//
//}