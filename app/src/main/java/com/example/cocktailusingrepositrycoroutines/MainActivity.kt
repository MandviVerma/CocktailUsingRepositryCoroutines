package com.example.cocktailusingrepositrycoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktailusingrepositrycoroutines.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainAdapter: MainAdapter
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        mainViewModel.getList()

        lifecycleScope.launchWhenStarted {
            mainViewModel._postStateFlow.collect {
                when (it) {

                    is ApiState.Loading -> {
                        binding.rvMain.isVisible = false
                        binding.progressBar.isVisible=true
                    }
                    is ApiState.Failure -> {
                        binding.rvMain.isVisible = false
                        binding.progressBar.isVisible=false
                        Log.d("main","onCreate: ${it.msg}")
                    }
                    is ApiState.Success -> {
                        binding.rvMain.isVisible = true
                        binding.progressBar.isVisible=false
                        mainAdapter.setData(it.data as java.util.ArrayList<Drink>)
                    }
                    is ApiState.Empty -> {

                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        mainAdapter = MainAdapter(this, ArrayList())
        binding.rvMain.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }
    }
}