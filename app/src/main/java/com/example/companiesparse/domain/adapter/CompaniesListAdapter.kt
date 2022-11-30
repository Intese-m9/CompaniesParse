package com.example.companiesparse.domain.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.companiesparse.R
import com.example.companiesparse.domain.models.complist.CompanyListItem
import com.example.companiesparse.presentation.DetailActivity
import kotlinx.android.synthetic.main.list_item.view.*

class CompaniesListAdapter: RecyclerView.Adapter<CompaniesListAdapter.CompaniesListViewHolder>() {
    private var listCompanies = emptyList<CompanyListItem>()//list add this data

    class CompaniesListViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent, false)
        return CompaniesListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompaniesListViewHolder, position: Int) {
        holder.itemView.tvName.text = listCompanies[position].name
        Glide.with(holder.itemView.context).load("https://lifehack.studio/test_task/${listCompanies[position].img}").centerCrop().into(holder.itemView.imageCompany)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("idPath", listCompanies[position].id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listCompanies.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CompanyListItem>){
        listCompanies = list
        notifyDataSetChanged()
    }
}