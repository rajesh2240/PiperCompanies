package library.location.freedocast.com.myapplication

import io.reactivex.Observable
import library.location.freedocast.com.myapplication.movieslist.GenreList

class Repository(private val apiCallInterface: ApiCallInterface) {

    fun execute(): Observable<GenreList> {
        return apiCallInterface.fetchProducts()
    }

}