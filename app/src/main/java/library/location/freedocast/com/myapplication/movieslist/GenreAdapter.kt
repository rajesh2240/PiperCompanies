package library.location.freedocast.com.myapplication.movieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import library.location.freedocast.com.myapplication.ProductBean
import library.location.freedocast.com.myapplication.databinding.ActivityMainBinding


class GenreAdapter : RecyclerView.Adapter<GenreAdapter.PeopleAdapterViewHolder>() {

    private var peopleList: ArrayList<ProductBean>

    var viewPool: RecyclerView.RecycledViewPool?? = null

    init {
        this.peopleList = ArrayList()
        viewPool = RecyclerView.RecycledViewPool()
    }

    var holder: PeopleAdapterViewHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val itemPeopleBinding: ActivityMainBinding = DataBindingUtil.inflate(
            layoutInflater, library.location.freedocast.com.myapplication.R.layout.activity_main,
            parent, false
        )
        holder = PeopleAdapterViewHolder(itemPeopleBinding, itemPeopleBinding.root)

        return holder!!
    }

    override fun onBindViewHolder(holder: PeopleAdapterViewHolder, position: Int) {

        holder.bindPeople(peopleList.get(position))

    }


    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return peopleList!!.size
    }

    fun setPeopleList(peopleList: ArrayList<ProductBean>) {
        this.peopleList = peopleList

    }

    inner class PeopleAdapterViewHolder : RecyclerView.ViewHolder {

        init {
            println("Init block")
        }

        var mItemPeopleBinding: ActivityMainBinding

        constructor(mItemPeopleBinding: ActivityMainBinding, itemView: View) : super(itemView) {
            this.mItemPeopleBinding = mItemPeopleBinding
        }

        fun bindPeople(genre: ProductBean) {
            mItemPeopleBinding.movie = genre
        }
    }
}