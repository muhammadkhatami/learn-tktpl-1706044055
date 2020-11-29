package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class WifiRecyclerViewAdapter(
    private val values: List<String>
) : RecyclerView.Adapter<WifiRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.wifi_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wifiItem = values[position]
        holder.idView.text = (position+1).toString()
        holder.contentView.text = wifiItem
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.wifiNumber)
        val contentView: TextView = view.findViewById(R.id.wifiContent)
    }
}