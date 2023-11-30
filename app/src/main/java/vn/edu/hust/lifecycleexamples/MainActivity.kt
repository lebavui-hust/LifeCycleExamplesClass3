package vn.edu.hust.lifecycleexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import vn.edu.hust.lifecycleexamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var count = 0

    val viewModel: MyViewModel by viewModels()

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textCount2.text = viewModel.count.toString()

        binding.buttonAddCount2.setOnClickListener {
            viewModel.addCount()
            binding.textCount2.text = viewModel.count.toString()
        }

        Log.v("TAG", "onCreate")

        if (savedInstanceState != null)
        {
            count = savedInstanceState.getInt("COUNT_VALUE")
        }

        binding.textCount.text = "$count"

        binding.buttonAddOne.setOnClickListener {
            count++
            binding.textCount.text = "$count"
        }

        binding.buttonOpen.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.buttonAdd.setOnClickListener {
            val secondFragment = SecondFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, secondFragment, "SECOND")
                .commit()
        }

        binding.buttonReplace.setOnClickListener {
            val secondFragment = SecondFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, secondFragment, "SECOND")
                .commit()
        }

        binding.buttonRemove.setOnClickListener {
            val firstFragment = supportFragmentManager.findFragmentByTag("FIRST")
            if (firstFragment != null)
                supportFragmentManager.beginTransaction()
                    .remove(firstFragment)
                    .commit()
        }

        lifecycle.addObserver(MyObserver())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("COUNT_VALUE", count)

        super.onSaveInstanceState(outState)
        Log.v("TAG", "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.v("TAG", "onRestoreInstanceState")

//        count = savedInstanceState.getInt("COUNT_VALUE")
//        textCount.text = "$count"
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("TAG", "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.v("TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("TAG", "onDestroy")
    }
}