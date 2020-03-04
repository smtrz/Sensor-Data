package com.tahir.pessl_instruments.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import com.tahir.pessl_instruments.Configurations.App
import com.tahir.pessl_instruments.Helpers.DateHelper
import com.tahir.pessl_instruments.Interfaces.NewsListInterface
import com.tahir.pessl_instruments.Models.DeviceInfo
import com.tahir.pessl_instruments.R
import kotlinx.android.synthetic.main.devices_list_item.view.*
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject


class StationAdapter(
    var context: Context,
    var articles: List<DeviceInfo>?


)

    : RecyclerView.Adapter<StationAdapter.NewsViewHolder>() {

    init {


        App.app.appLevelComponent.inject(this)
    }

    @Inject
    lateinit var date_helper: DateHelper
    var holding: ArrayList<Int>? = ArrayList()
    fun loadItems(newItems: List<DeviceInfo>?, ni: NewsListInterface) {

        articles = newItems
        ni.ifListisEmpty(articles!!.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.devices_list_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.CEILING
        val model: DeviceInfo = articles!!.get(position);
        holder.txtDeviceType!!.text = model.info.device_name
        holder.deviceID!!.text = "Station ID : " + model.info.device_id.toString().trim()


        if (model.name.custom.equals("")) {

            holder.txtCustomName!!.visibility = View.GONE
        } else {
            holder.txtCustomName!!.visibility = View.VISIBLE

        }


        holder.txtCustomName!!.text = "Custom Name : " + model.name.custom.trim()


        // holder.last_comm!!.visibility!! = View.GONE
        holder.last_commun!!.text = date_helper.Get_Duration(
            model.dates.last_communication,
            date_helper.get_current_datetime_24hr()
        )
        if (model.networking != null && model.networking.rssi_pct != "" && model.networking.rssi_pct != null) {

            holder.network_signal!!.text =
                model.networking.rssi_pct + "%".trim()

        }



        if (model.meta.battery < 5800) {
            holder.battery!!.text = "Empty"

        } else if ((model.meta.battery > 6700)) {

            holder.battery!!.text = "Full"

        } else {

            holder.battery!!.text = "Sufficient"
        }
        holder.air_temp!!.text = df.format(model.meta.airTemp).toString()
        holder.relative_himidity!!.text = df.format(model.meta.rh).toString()
        if (model.meta.rain24h != null) {
            holder.rain!!.text =
                df.format(model.meta.rain24h.sum).toString() + " mms"


        }

//holder.air_temp = model.meta

        holder.cardView!!.setOnClickListener {
            TransitionManager.beginDelayedTransition(holder.cardView!!)


            //  holding?.add(position)

            if (holder.bottom_bar_1!!.visibility == View.GONE && holder.bottom_bar_2!!.visibility == View.GONE  &&holder.last_commun!!.visibility == View.GONE) {

                holder.bottom_bar_1!!.visibility = View.VISIBLE
                holder.bottom_bar_2!!.visibility = View.VISIBLE
                 holder.last_commun!!.visibility = View.VISIBLE

                // holder.las
            } else {
//
                // holding?.remove(position);
                //holder.third_line!!.visibility = View.GONE


                holder.bottom_bar_1!!.visibility = View.GONE
                holder.bottom_bar_2!!.visibility = View.GONE
                holder.last_commun!!.visibility = View.GONE

            }
        }
        //  try {
        /*  holder.name!!.text = articles!![position].author
          holder.heading!!.text = articles!![position].name
          holder.desc!!.text = articles!![position].description

          Picasso.get().load(articles!![position].avatar).into(holder.img)

          holder.lang!!.text = articles!![position].language
          holder.star!!.text = articles!![position].stars.toString()

          holder.fork!!.text = articles!![position].forks

          holder.cardView!!.setOnClickListener {
              TransitionManager.beginDelayedTransition(holder.cardView!!)

              if (holder.third_line!!.visibility == View.GONE && holder.last_line!!.visibility == View.GONE) {
                  holder.third_line!!.visibility = View.VISIBLE

                  holder.last_line!!.visibility = View.VISIBLE
              } else {

                  holder.third_line!!.visibility = View.GONE

                  holder.last_line!!.visibility = View.GONE
              }
          }


      } catch (e: Exception) {
          //eat this one.

      }
*/
    }

    override fun getItemCount(): Int {
        return if (articles != null) {
            articles!!.size
        } else {

            0
        }

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun checkArray(checkvalue: Int): Boolean {

        for (i in this.holding!!) {

            if (i == checkvalue) {

                return true;
            }
        }
        return false;
    }

    class NewsViewHolder
        (itemView: View) : RecyclerView.ViewHolder(itemView) {


        internal var txtDeviceType: TextView? = itemView.txtDeviceType
        internal var img: ImageView? = itemView.image
        internal var deviceID: TextView? = itemView.deviceID
        internal var txtCustomName: TextView? = itemView.txtCustomName
        // internal var last_comm: TextView? = itemView.last_comm
        internal var network_signal: TextView? = itemView.network_signal
        internal var battery: TextView? = itemView.battery
        internal var air_temp: TextView? = itemView.air_temp

        internal var relative_himidity: TextView? = itemView.relative_himidity
        internal var rain: TextView? = itemView.rain
        internal var cardView: CardView? = itemView.cardView
        internal var bottom_bar_1: LinearLayout? = itemView.bottom_bar_1
        internal var bottom_bar_2: LinearLayout? = itemView.bottom_bar_2
        internal var bottom_bar_3: LinearLayout? = itemView.bottom_bar_3
        internal var last_commun: TextView? = itemView.last_commun


        //internal var third_line: LinearLayout? = itemView.third_layout
    }


}