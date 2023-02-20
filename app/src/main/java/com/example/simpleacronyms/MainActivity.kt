package com.example.simpleacronyms

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleacronyms.adapter.AcronymsAdapter
import com.example.simpleacronyms.databinding.ActivityMainBinding
import com.example.simpleacronyms.viewmodel.AcronymsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: AcronymsViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var acronymsAdapter: AcronymsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.shortFormEditText.doAfterTextChanged { inputText ->
            viewModel.getLongForm(inputText.toString())
        }

        viewModel.content.observe(this) {
            setupRecyclerView(it, binding.emptyView)
        }

        viewModel.isLoading.observe(this) { isLoading ->
            if (isLoading)
                binding.progressBar.visibility = View.VISIBLE
            else
                binding.progressBar.visibility = View.GONE
        }
    }

    private fun setupRecyclerView(longForms: List<String>, emptyView: TextView) =
        binding.mainRecyclerView.apply {
            if (longForms.isEmpty()) {
                this.visibility = View.GONE;
                emptyView.visibility = View.VISIBLE;
            } else {
                this.visibility = View.VISIBLE;
                emptyView.visibility = View.GONE;
            }
            acronymsAdapter = AcronymsAdapter(longForms)
            adapter = acronymsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
}