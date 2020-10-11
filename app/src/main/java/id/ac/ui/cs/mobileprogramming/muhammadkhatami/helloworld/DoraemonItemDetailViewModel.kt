package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DoraemonItemDetailViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var doraemonContent: String = ""
    var doraemonTitle: String = ""

    fun setDoraemonContent(doraemonContent: String, doraemonTitle: String){
        this.doraemonContent = doraemonContent
        this.doraemonTitle = doraemonTitle
    }
}