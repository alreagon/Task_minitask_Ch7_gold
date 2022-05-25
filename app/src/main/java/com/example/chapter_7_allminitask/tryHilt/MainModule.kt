package com.example.chapter_7_allminitask.tryHilt

import android.content.Context
import com.example.chapter_7_allminitask.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ActivityComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named

@Module
@InstallIn(ActivityComponentManager::class)
object MainModule {

//    @Singleton //singleton ini gk jalan karena cmn bisa jalan di ApplicationComponentManager
    @ActivityScoped
    @Provides
    @Named("String2")
    fun provideTestString2(
    @ApplicationContext
    context: Context
    ) = context.getString(R.string.string_to_inject)

}