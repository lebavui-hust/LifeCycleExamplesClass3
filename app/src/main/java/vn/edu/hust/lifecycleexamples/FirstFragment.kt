package vn.edu.hust.lifecycleexamples

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FirstFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.v("FRAGMENT", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("FRAGMENT", "onCreate")

        lifecycle.addObserver(MyObserver())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.v("FRAGMENT", "onCreateView")
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("FRAGMENT", "onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.v("FRAGMENT", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("FRAGMENT", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("FRAGMENT", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("FRAGMENT", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v("FRAGMENT", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("FRAGMENT", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("FRAGMENT", "onDetach")
    }
}