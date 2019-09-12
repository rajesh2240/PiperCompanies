package library.location.freedocast.com.myapplication.movieslist

import library.location.freedocast.com.myapplication.ProductBean
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ads", strict = false)
class GenreList {

    @field:ElementList(name = "ad", inline = true,required = false)
    var ads: ArrayList<ProductBean>? = null

}