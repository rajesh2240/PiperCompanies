package library.location.freedocast.com.myapplication.movieslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_news.*
import library.location.freedocast.com.myapplication.CApplication
import library.location.freedocast.com.myapplication.ProductBean
import library.location.freedocast.com.myapplication.R

class ProductDetailsActivity : AppCompatActivity() {


    var path: ProductBean = ProductBean()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as CApplication).component.doInjection(this)
        setContentView(R.layout.recyclerview_news)

        path = this.intent.extras.getParcelable("bean")

        Picasso.get().load(path.productThumbnail).into(imageViewDetails)

        nameDetails.text = path.productName

        ratingDetails.text = path.numberOfRatings


    }


}