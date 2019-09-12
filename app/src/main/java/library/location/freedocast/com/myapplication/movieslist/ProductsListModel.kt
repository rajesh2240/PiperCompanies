package library.location.freedocast.com.myapplication.movieslist

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import library.location.freedocast.com.myapplication.ProductBean
import library.location.freedocast.com.myapplication.ObservableViewModel
import library.location.freedocast.com.myapplication.R
import library.location.freedocast.com.myapplication.Repository


class ProductsListModel() : ObservableViewModel() {
    lateinit var repository: Repository

    constructor(repository: Repository) : this() {
        this.repository = repository
    }


    var listData: MutableLiveData<ArrayList<ProductBean>> = MutableLiveData()


    fun onClickRajesh(view: View, product: ProductBean) {
        when (view.id) {
            R.id.imageView -> {
                val intent = Intent(view.context, ProductDetailsActivity::class.java)
                intent.putExtra("bean", product)
                view.context.startActivity(intent);
            }
        }
    }

    fun fetchInformation() {
        Log.e("fetch Data", "fetch Data")
        compositeDisposable =
            repository.execute().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::data, this::error)

    }


    lateinit var compositeDisposable: Disposable

    fun data(list: GenreList) {
        Log.e("fetch Data", "fetch Data SUCCESS")

        for (data in list.ads!!) {
            Log.e("Response: ", "--->  " + data.categoryName)
        }
        listData.postValue(list.ads)
    }

    fun error(error: Throwable) {
        error.printStackTrace()
        listData.postValue(ArrayList())
    }

    private fun unSubscribeFromObservable() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose()
        }
    }

    fun reset() {
        unSubscribeFromObservable()
    }


}