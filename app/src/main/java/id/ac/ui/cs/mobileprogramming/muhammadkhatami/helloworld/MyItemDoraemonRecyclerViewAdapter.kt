package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld.doraemon.DoraemonContent

import id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld.doraemon.DoraemonContent.DoraemonItem

/**
 * [RecyclerView.Adapter] that can display a [DoraemonItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemDoraemonRecyclerViewAdapter(
    private val values: MutableList<DoraemonContent.DoraemonItem>,
    private val viewModel: DoraemonItemDetailViewModel
) : RecyclerView.Adapter<MyItemDoraemonRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_doraemon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.title
        holder.itemView.setOnClickListener{
            viewModel.setDoraemonContent(item.doraemonContent, item.title)
            (holder.itemView.context as FragmentActivity).supportFragmentManager.beginTransaction().
            replace(R.id.doraemon_list_fragment, DoraemonItemDetail()).commit()
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}