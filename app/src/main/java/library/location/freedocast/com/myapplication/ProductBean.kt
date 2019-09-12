package library.location.freedocast.com.myapplication

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import library.location.freedocast.com.myapplication.movieslist.ProductDetailsActivity
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "ad", strict = false)
class ProductBean() : ObservableViewModel(), Parcelable {

    fun onClickRajesh(view: View, product: ProductBean) {
        when (view.id) {
            R.id.imageView -> {
                val intent = Intent(view.context, ProductDetailsActivity::class.java)
                intent.putExtra("bean", product)
                view.context.startActivity(intent);
            }
        }
    }


    @field:Element(name = "productName", required = false)
    @Bindable
    var productName: String = ""
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.productName)
        }

    @field:Element(name = "numberOfRatings", required = false)
    @Bindable
    var numberOfRatings: String = ""
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.productName)
        }

    @field:Element(name = "productThumbnail", required = false)
    @Bindable
    var productThumbnail: String = ""
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.productName)
        }

    @field:Element(name = "categoryName", required = false)
    @Bindable
    var categoryName: String = ""
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.categoryName)
        }

    lateinit var respositary: Repository

    constructor(respositary: Repository) : this() {
        this.respositary = respositary
    }

    constructor(parcel: Parcel) : this() {
        productName = parcel.readString()
        categoryName = parcel.readString()

        numberOfRatings = parcel.readString()
        productThumbnail = parcel.readString()

    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(productName)
        parcel.writeString(categoryName)
        parcel.writeString(numberOfRatings)
        parcel.writeString(productThumbnail)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductBean> {
        override fun createFromParcel(parcel: Parcel): ProductBean {
            return ProductBean(parcel)
        }

        override fun newArray(size: Int): Array<ProductBean?> {
            return arrayOfNulls(size)
        }

        @JvmStatic
        @BindingAdapter("imageUrlExtra")
        fun loadImage(view: ImageView, imageUrlData: String) {
            Picasso.get().load(imageUrlData).into(view);
        }
    }

}