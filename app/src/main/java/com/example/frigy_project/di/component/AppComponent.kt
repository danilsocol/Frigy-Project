package com.example.frigy_project.di.component

import android.content.Context
import com.example.frigy_project.di.module.AppModule
import com.example.frigy_project.di.module.DataModule
import com.example.frigy_project.di.module.DomainModule
import com.example.frigy_project.di.factory.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
@Singleton
interface AppComponent {
    fun viewModelFactory(): ViewModelFactory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContext(context: Context): Builder
        fun build(): AppComponent
    }
}