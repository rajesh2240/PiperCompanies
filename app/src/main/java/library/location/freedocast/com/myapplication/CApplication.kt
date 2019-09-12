package library.location.freedocast.com.myapplication

import DaggerAppComponent
import android.app.Application


class CApplication : Application() {


    val component by lazy {
        DaggerAppComponent
            .builder()
            .networkModule(NetworkModule())
            .build()
    }

    public fun getCustomComponent() = component

    override fun onCreate() {
        super.onCreate()
        component.doInjection(this)
    }


}