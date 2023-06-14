package com.example.frigy_project.app

import android.app.Application
import com.example.frigy_project.di.component.AppComponent
import com.example.frigy_project.di.component.DaggerAppComponent

class App : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
       component = DaggerAppComponent.builder().appContext(this).build()
    }
}