package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.ItemVaccineResultBinding

class MainAdapter(private val dataSet: List<VaccineBody>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemVaccineResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = dataSet.size

    inner class ViewHolder(private val binding: ItemVaccineResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.itemFacilityNameTv.text = "${dataSet[position].facilityName}"
            binding.itemZipCodeTv.text = "(${dataSet[position].zipCode})"
            binding.itemAddressTv.text = " ${dataSet[position].address}"

            if (dataSet[position].phoneNumber.isNullOrBlank()) {
                binding.itemPhoneNumberTv.text = "전화번호를 확인할 수 없습니다."
            } else {
                binding.itemPhoneNumberTv.text = dataSet[position].phoneNumber
            }
        }
    }
}