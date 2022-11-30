package com.example.companiesparse.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.companiesparse.data.repository.Repository
import com.example.companiesparse.domain.models.complist.CompanyList
import com.example.companiesparse.domain.models.details.DetailsCompany
import kotlinx.coroutines.launch
import retrofit2.Response


class CompanyViewModel:ViewModel() {
    private var repository = Repository()

    var companyList: MutableLiveData<Response<CompanyList>> = MutableLiveData()

    var detailsList: MutableLiveData<Response<DetailsCompany>> = MutableLiveData()

    fun getComapanies(){
        viewModelScope.launch {
            companyList.value = repository.getCompanies()
        }
    }
    fun getDetails(pathId: String) {
        viewModelScope.launch {
            detailsList.value = repository.getDetails(pathId)
        }
    }
}