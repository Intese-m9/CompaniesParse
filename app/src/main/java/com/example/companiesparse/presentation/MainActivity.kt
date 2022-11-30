package com.example.companiesparse.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.companiesparse.R
import com.example.companiesparse.domain.adapter.CompaniesListAdapter
import com.example.companiesparse.presentation.viewmodel.CompanyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adapter = CompaniesListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this)[CompanyViewModel::class.java]//инициализация ViewModel
        rv_comp.adapter = adapter
        viewModel.getComapanies()
        viewModel.companyList.observe(this){ list ->
            list.body()?.let { adapter.setList(it) }
        }
    }
}