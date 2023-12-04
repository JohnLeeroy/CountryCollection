package com.jli.countrycollection.countrylist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jli.countrycollection.databinding.CountryRowBinding

class CountryListAdapter(val onItemClicked: (CountryUiModel) -> Unit) : ListAdapter<CountryUiModel, CountryRowViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryRowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CountryRowViewHolder(CountryRowBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CountryRowViewHolder, position: Int) {
        holder.bind(getItem((position)))
        holder.itemView.setOnClickListener {
            onItemClicked(getItem(position))
        }
    }

    private companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CountryUiModel>() {
            override fun areItemsTheSame(
                oldItem: CountryUiModel,
                newItem: CountryUiModel
            ): Boolean {
                return oldItem.code == newItem.code
            }

            override fun areContentsTheSame(
                oldItem: CountryUiModel,
                newItem: CountryUiModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}