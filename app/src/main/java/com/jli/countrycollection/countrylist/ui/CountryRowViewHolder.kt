package com.jli.countrycollection.countrylist.ui

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jli.countrycollection.databinding.CountryRowBinding

class CountryRowViewHolder(private val binding: CountryRowBinding) : ViewHolder(binding.root) {
    fun bind(country: CountryUiModel) {
        val nameRegionLabel = "${country.name}, ${country.region}"
        binding.nameRegionLabel.text = nameRegionLabel
        binding.codeLabel.text = country.code
        binding.capitalLabel.text = country.capital
    }
}