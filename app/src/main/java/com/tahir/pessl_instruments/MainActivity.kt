package com.tahir.pessl_instruments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahir.pessl_instruments.Adapters.StationAdapter
import com.tahir.pessl_instruments.Interfaces.NewsListInterface
import com.tahir.pessl_instruments.Models.DeviceInfo
import com.tahir.pessl_instruments.ViewModels.TrendingActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsListInterface {
    lateinit var newsViewModel: TrendingActivityViewModel
    lateinit var adapter: StationAdapter
    // internal var list: List<BaseTrending>? = null

    var list: List<DeviceInfo>? = null
    //internal var a: List<BaseTrending>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {

        // more.setOnClickListener(this)
        // btn_layout.setOnClickListener(this)
        //rv_repos?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // setting up recyclerview and also binding activity with the view-model
        newsViewModel = ViewModelProviders.of(this).get(TrendingActivityViewModel::class.java)
        rv_repos?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = StationAdapter(this, list)

        rv_repos?.setAdapter(adapter)
        // pull to refresh
        //  pullToRefresh?.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
        newsViewModel.callNewsAPI().observe(this, Observer {

            list = it;

            //   adapter.loadItems()
            adapter.loadItems(it, this)
            adapter.notifyDataSetChanged()

        })
        //    pullToRefresh?.setRefreshing(false)
        //})

    }

    override fun ifListisEmpty(count: Int) {
    }
}
