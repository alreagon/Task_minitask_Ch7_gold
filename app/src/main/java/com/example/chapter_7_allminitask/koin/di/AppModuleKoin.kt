package com.example.chapter_7_allminitask.koin.di

import com.example.chapter_7_allminitask.BuildConfig
import com.example.chapter_7_allminitask.koin.data.RepositoryKoin
import com.example.chapter_7_allminitask.koin.data.service.ApiHelperKoin
import com.example.chapter_7_allminitask.koin.data.service.ApiServiceKoin
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModuleKoin = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(ApiServiceKoin::class.java)
    }


    single {
        return@single ApiHelperKoin(get())
    }
//    singleOf(::apiHelperKoin)


}
