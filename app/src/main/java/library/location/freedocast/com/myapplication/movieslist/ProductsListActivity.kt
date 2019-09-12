package library.location.freedocast.com.myapplication.movieslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import library.location.freedocast.com.myapplication.*
import library.location.freedocast.com.myapplication.databinding.ActivtyRecyclerviewBinding
import javax.inject.Inject
import androidx.recyclerview.widget.GridLayoutManager


class ProductsListActivity : AppCompatActivity() {

    lateinit var binding: ActivtyRecyclerviewBinding

    lateinit var viewModel: ProductsListModel


    @set:Inject
    var viewModelFactory: ViewModelFactory? = null

    var moviesAdapter: GenreAdapter = GenreAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as CApplication).component.doInjection(this)

        binding = DataBindingUtil.setContentView(
            this, R.layout.activty_recyclerview
        )
        binding.lifecycleOwner = this

        val layoutManager = GridLayoutManager(this, 3)

        binding.recyclerView.layoutManager = layoutManager!!

        binding.recyclerView.setHasFixedSize(false);

        binding.recyclerView.addItemDecoration(
            EqualSpacingItemDecoration(
                10, EqualSpacingItemDecoration.GRID
            )
        )

        binding.recyclerView.adapter = moviesAdapter

        binding.recyclerView.isNestedScrollingEnabled = false

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductsListModel::class.java)

        viewModel.listData.observe(this, changeObserver);

        viewModel.fetchInformation()

    }


    val changeObserver = Observer<ArrayList<ProductBean>> { value ->
        value?.let {
            moviesAdapter.setPeopleList(value)
            moviesAdapter.notifyDataSetChanged()

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.reset()
    }


}