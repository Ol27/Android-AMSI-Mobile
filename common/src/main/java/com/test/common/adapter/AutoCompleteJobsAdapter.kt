package com.test.common.adapter

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import com.test.common.databinding.SearchJobDropdownItemBinding
import com.test.domain.model.Job

class AutoCompleteJobsAdapter(
    context: Context
) : ArrayAdapter<String>(context, 0) {

    private var list: List<String> = emptyList()
    var filteredList: List<String> = emptyList()
    private var searchText: String = ""

    fun submitList(jobs: List<Job>) {
        list = jobs.map { it.title }.distinct()
        filteredList = list.toList()
        notifyDataSetChanged()
    }

    override fun getCount(): Int = filteredList.size

    override fun getItem(position: Int): String? = filteredList.getOrNull(position)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val binding: SearchJobDropdownItemBinding

        if (view == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            binding = SearchJobDropdownItemBinding.inflate(inflater, parent, false)
            view = binding.root
            view.tag = binding
        } else {
            binding = view.tag as SearchJobDropdownItemBinding
        }

        val itemText = filteredList[position]
        binding.dropdownItemDivider.visibility = if (position == 0) View.GONE else View.VISIBLE

        val spannable = SpannableString(itemText)
        searchText.lowercase().let { lowercasedSearchText ->
            itemText.lowercase().indexOf(lowercasedSearchText).takeIf { index ->
                index != -1
            }?.let { index ->
                spannable.setSpan(
                    ForegroundColorSpan(Color.BLACK),
                    index,
                    index + lowercasedSearchText.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        binding.mtvDropdownItem.text = spannable
        return view
    }

    override fun getFilter(): Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filterResults = FilterResults()
            searchText = constraint?.toString() ?: ""

            if (searchText.isBlank()) {
                filterResults.values = list
            } else {
                filterResults.values =
                    list.filter { it.lowercase().contains(searchText.lowercase()) }
            }
            filterResults.count = (filterResults.values as List<*>).size
            return filterResults
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults) {
            filteredList = results.values as List<String>
            notifyDataSetChanged()
        }
    }
}