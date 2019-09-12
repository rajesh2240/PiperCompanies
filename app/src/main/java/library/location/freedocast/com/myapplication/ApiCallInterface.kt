package library.location.freedocast.com.myapplication

import io.reactivex.Observable
import library.location.freedocast.com.myapplication.movieslist.GenreList
import retrofit2.http.GET

interface ApiCallInterface {


    @GET("/getAds?id=236&password=OVUJ1DJN&siteId=10777&deviceId=4230&sessionId=techtestsession&totalCampaignsRequested=10&lname=palepu")
    fun fetchProducts(): Observable<GenreList>
}
