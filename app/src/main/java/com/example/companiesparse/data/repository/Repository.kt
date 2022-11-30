package com.example.companiesparse.data.repository

import com.example.companiesparse.data.api.RetrofitHelper
import com.example.companiesparse.domain.models.complist.CompanyList
import com.example.companiesparse.domain.models.details.DetailsCompany
import retrofit2.Response

class Repository {
    suspend fun getCompanies(): Response<CompanyList>{
        return RetrofitHelper.api.getCompanies()
    }
    suspend fun getDetails(pathId: String): Response<DetailsCompany>{
        return RetrofitHelper.api.getDetain(pathId)
    }
}