package com.example.companiesparse.domain.models.details

data class DetailsCompanyItem(
    val description: String,
    val id: String,
    val img: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val phone: String,
    val www: String
)