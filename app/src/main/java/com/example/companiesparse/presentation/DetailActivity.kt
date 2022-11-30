package com.example.companiesparse.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.companiesparse.R
import com.example.companiesparse.presentation.viewmodel.CompanyViewModel
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    private lateinit var phoneNumber: String
    private lateinit var url: String
    private lateinit var locationLat: String
    private lateinit var locationLon: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val idPath:String = intent.getStringExtra("idPath").toString()
        val viewModel = ViewModelProvider(this)[CompanyViewModel::class.java]//инициализация ViewModel
        viewModel.getDetails(idPath)
        viewModel.detailsList.observe(this){ list ->
            list.body()?.let {
                Glide.with(this).load("https://lifehack.studio/test_task/${it[0].img}").centerCrop().into(imageCompany)
                tvName.text = it[0].name
                tvDesc.text = it[0].description
                phoneNumber = it[0].phone
                url = it[0].www
                locationLat = it[0].lat.toString()
                locationLon = it[0].lon.toString()
            }
        }
        phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }
        internet.setOnClickListener{
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://$url"))
            this.startActivity(intent)
        }
        location.setOnClickListener{
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/@$locationLat,$locationLon,11z?hl=ru-RU"))
            this.startActivity(intent)
        }
    }
}