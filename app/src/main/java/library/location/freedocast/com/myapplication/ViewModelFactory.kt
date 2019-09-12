package library.location.freedocast.com.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import library.location.freedocast.com.myapplication.movieslist.ProductsListModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(var repository: Repository) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsListModel::class.java!!)) {
            return ProductsListModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
