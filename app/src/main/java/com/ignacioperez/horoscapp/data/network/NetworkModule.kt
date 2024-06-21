package com.ignacioperez.horoscapp.data.network

import com.ignacioperez.horoscapp.BuildConfig.BASE_URL
import com.ignacioperez.horoscapp.data.RepositoryImpl
import com.ignacioperez.horoscapp.data.core.interceptors.AuthInterceptor
import com.ignacioperez.horoscapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//modulo para inyectar datos de data a domain con daggerHilt (no es directo porque data usa retrofit)
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //cuando se intente sacar el inject con dagger de un objecto retrofit, la app va a encontrar estre provides y lo va a entregar
    @Provides
    @Singleton //solo crea esta instancia una vez
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient) //aqui se pone el interceptor
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService {
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeApiService): Repository {
        return RepositoryImpl(apiService)
    }
}