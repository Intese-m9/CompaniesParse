package com.example.companiesparse.data.api

import com.example.companiesparse.domain.models.complist.CompanyList
import com.example.companiesparse.domain.models.details.DetailsCompany
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/test_task/test.php")
    suspend fun getCompanies(): Response<CompanyList>
    @GET("/test_task/test.php")
    suspend fun getDetain(
    @Query("id") pathId: String
    ):Response<DetailsCompany>

}