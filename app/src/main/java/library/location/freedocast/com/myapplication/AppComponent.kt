
import dagger.Component
import library.location.freedocast.com.myapplication.CApplication
import library.location.freedocast.com.myapplication.NetworkModule
import library.location.freedocast.com.myapplication.movieslist.ProductDetailsActivity
import library.location.freedocast.com.myapplication.movieslist.ProductsListActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun doInjection(productsListActivity: ProductsListActivity)
    fun doInjection(productDetailsActivity: ProductDetailsActivity)
    fun doInjection(application: CApplication)

}