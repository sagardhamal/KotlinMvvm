package com.pibusa.firstmvvmapp

import android.app.Application
import com.pibusa.firstmvvmapp.data.network.MyApi
import com.pibusa.firstmvvmapp.data.network.NetworkConnectionInterceptor
import com.pibusa.firstmvvmapp.ui.login.AuthViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }



    }

}