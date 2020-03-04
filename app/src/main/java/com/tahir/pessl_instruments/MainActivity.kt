package com.tahir.pessl_instruments

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahir.pessl_instruments.Adapters.StationAdapter
import com.tahir.pessl_instruments.Interfaces.NewsListInterface
import com.tahir.pessl_instruments.Models.DeviceInfo
import com.tahir.pessl_instruments.ViewModels.TrendingActivityViewModel
import kotlinx.android.synthetic.main.act_toolbar.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), NewsListInterface, View.OnClickListener {
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

        rv_repos?.adapter = adapter
        more.setOnClickListener(this)
        // pull to refresh
        //  pullToRefresh?.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
        newsViewModel.callNewsAPI().observe(this, Observer {

            list = it

            //   adapter.loadItems()
            adapter.loadItems(it, this)
            adapter.notifyDataSetChanged()

        })
        //    pullToRefresh?.setRefreshing(false)
        //})

    }

    override fun ifListisEmpty(count: Int) {
    }

    fun popMenu() {

        val popupMenu: PopupMenu = PopupMenu(this, more)


        popupMenu.menuInflater.inflate(R.menu.popupmenu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId) {
                R.id.action_sort_star -> {
                    //    Log.d("##","pop clicked");
                    // Collections.sort(list.);
                    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
                    // list?.sortedByDescending {sdf.parse(it.dates.last_communication) }


                    Collections.sort(list,
                        Comparator { lhs, rhs ->
                            sdf.parse(lhs.dates.last_communication)
                                .compareTo(sdf.parse(rhs.dates.last_communication))
                        })

                    adapter.loadItems(list?.reversed(), this)
                    adapter.notifyDataSetChanged()


                    // adapter.loadItems(newsViewModel.sorted_allItems_bystar, this)0
                    // adapter.notifyDataSetChanged()
                }
                /*   R.id.action_sort_name -> {

                       //adapter.loadItems(newsViewModel.sorted_allItems_byname, this)
                       //adapter.notifyDataSetChanged()

                   }*/

            }

            true
        })
        popupMenu.show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.more -> {

                popMenu()

            }

        }
    }
/*
    fun sortData(devices: List<DeviceInfo>): List<DeviceInfo>? {
        for (DeviceInfo in devices) {
            var DateStart: Date? = null

            val sdf =
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
            DateStart = sdf.parse(DeviceInfo.dates.last_communication)

            if () {


            }

        }


        return null;
    }*/
}
