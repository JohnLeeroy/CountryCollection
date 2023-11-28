package com.jli.countrycollection.countrylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jli.countrycollection.countrylist.ui.CountryListAdapter
import com.jli.countrycollection.databinding.CountryListFragmentBinding
import kotlinx.coroutines.launch

class CountryListFragment : Fragment() {

    private var _binding: CountryListFragmentBinding? = null
    private val binding get() = _binding!!

    private val countryListAdapter = CountryListAdapter()

    private val countryListViewModel: CountryListViewModel by viewModels { CountryListViewModel.Factory }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CountryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.countryListRecyclerView.adapter = countryListAdapter
        binding.countryListRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        countryListViewModel.getCountryList()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                countryListViewModel.uiState.collect {
                    countryListAdapter.submitList(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}