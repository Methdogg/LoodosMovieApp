package com.methdogg.lodosmovieapp.ui.main

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.methdogg.lodosmovieapp.R
import com.methdogg.lodosmovieapp.base.BaseActivity
import com.methdogg.lodosmovieapp.data.model.Movie
import com.methdogg.lodosmovieapp.databinding.ActivityMainBinding
import com.methdogg.lodosmovieapp.extension.setDivider
import com.methdogg.lodosmovieapp.extension.setVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var dataBinding: ActivityMainBinding

    private lateinit var listObserver: Observer<List<Movie>>
    private lateinit var loadingStateObserver: Observer<Boolean>

    private lateinit var movieAdapter: MoviesAdapter

    override fun initViews() {
        viewModel = ViewModelProvider(
            this@MainActivity,
            viewModelFactory
        ).get(MainViewModel::class.java)

        dataBinding = ActivityMainBinding.inflate(layoutInflater).apply {
            this.viewModel = viewModel
        }

        listObserver = Observer {
            setRecyclerViewAdapter(it)
        }

        loadingStateObserver = Observer { isLoading ->
            if (isLoading){
                dialogHelper.showLoadingDialog()
            }
            else
                dialogHelper.dismissLoadingDialog()
        }

        viewModel.movies.observe(this, listObserver)
        viewModel.loadingState.observe(this, loadingStateObserver)

        buttonSearch.setOnClickListener {
            viewModel.getMovies(
                searchQuery = editTextSearch.text.toString()
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.movies.removeObserver(listObserver)
        viewModel.stop()
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    private fun setRecyclerViewAdapter(list: List<Movie>?) {
        list?.let {
            textViewEmptyList.setVisible(list.isEmpty())

            movieAdapter = MoviesAdapter(this@MainActivity, it)

            with(recyclerViewMovie) {
                setVisible(list.isNotEmpty())

                adapter = movieAdapter

                layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

                setDivider(
                    drawableRes = R.drawable.list_divider
                )
            }
        }
    }

}