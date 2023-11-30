package vn.edu.hust.lifecycleexamples

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var count = 0
    fun addCount() {
        count++
    }
}