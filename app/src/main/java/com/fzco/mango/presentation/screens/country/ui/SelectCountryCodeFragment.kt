package com.fzco.mango.presentation.screens.country.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.fzco.mango.databinding.FragmentSelectCountryCodeBinding
import com.fzco.mango.databinding.ItemPhoneCountryBinding
import com.fzco.mango.presentation.common.fragments.mvi.MviFragment
import com.fzco.mango.presentation.screens.auth.send.ui.SendAuthCodeFragment
import com.fzco.mango.presentation.screens.country.contract.SelectCountryCodeState
import com.fzco.mango.presentation.screens.country.vm.SelectCountryCodeViewModel
import com.fzco.mango.presentation.utils.view.onclick
import com.fzco.mango.presentation.utils.view.recycler.createItemBindingDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class SelectCountryCodeFragment
    : MviFragment<SelectCountryCodeViewModel, FragmentSelectCountryCodeBinding>(
        viewModelClass = SelectCountryCodeViewModel::class,
        bindingBlock = FragmentSelectCountryCodeBinding::inflate) {

    private fun createCountryItemDelegate() = createItemBindingDelegate<
            SelectCountryCodeState.CountryData, ItemPhoneCountryBinding>(
        bindingBlock = ItemPhoneCountryBinding::inflate,
        block = {
            binding.root onclick {
                toast(item.countryCode)
                setFragmentResult(
                    SendAuthCodeFragment.FragmentsResultKey.PhoneCountryCode,
                    bundleOf(
                        SendAuthCodeFragment.DataKey.CountryCode to item.countryCode
                    )
                )
                requireActivity().finish()
            }

            bind {
                binding.renderItem(item)
            }
        }
    )

    private fun ItemPhoneCountryBinding.renderItem(
        item: SelectCountryCodeState.CountryData
    ) = with(item) {
        txtCountryEmoji.text = countryEmoji
        txtCountryTitle.text = countryName
    }

    private val countriesItemAdapter = ListDelegationAdapter(
        createCountryItemDelegate()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
        handleState()
        setUpListeners()
        viewModel.loadCountries()
    }

    private fun handleState() = observe(stateCollectLaunch = {
        viewModel.stateFlow.collect { it.render() }
    })

    @SuppressLint("NotifyDataSetChanged")
    private fun SelectCountryCodeState.render() = with(binding) {
        toast(countries.size.toString())
        countriesItemAdapter.items = countries
        countriesItemAdapter.notifyDataSetChanged()
    }

    private fun setUpListeners() = with(binding) {
        val searchFieldListener = object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(text: String): Boolean {
                viewModel.searchCountry(text)
                return true
            }

            override fun onQueryTextChange(text: String): Boolean {
                viewModel.searchCountry(text)
                return true
            }
        }

        fieldSearch.setOnQueryTextListener(searchFieldListener)
    }

    private fun setUpRecycler() = with(binding) {
        recyclerCountries.adapter = countriesItemAdapter
    }
}