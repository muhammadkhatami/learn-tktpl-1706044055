package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.math.log

class DoraemonItemDetail : Fragment() {

    companion object {
        fun newInstance() = DoraemonItemDetail()
    }

    private lateinit var viewModel: DoraemonItemDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(activity!!).get(DoraemonItemDetailViewModel::class.java)
        val view: View = inflater.inflate(R.layout.doraemon_item_detail_fragment, container, false)
        val textContent: TextView = view.findViewById(R.id.textContent)
        val textTitle: TextView = view.findViewById(R.id.textTitle)
        textContent.setText(viewModel.doraemonContent.toString())
        textTitle.setText(viewModel.doraemonTitle.toString())
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DoraemonItemDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}