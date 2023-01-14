package com.incomee.incomee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.incomee.incomee.adapter.FiltersAdapter
import kotlinx.android.synthetic.main.fragment_operations.*


class OperationsFragment : Fragment(R.layout.fragment_operations) {

    private lateinit var filtersAdapter: FiltersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_operations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filtersAdapter = FiltersAdapter()
        val layoutManager: LayoutManager = LinearLayoutManager(context, HORIZONTAL, false)
        filtersRecyclerView.apply {
            adapter = filtersAdapter
            setLayoutManager(layoutManager)
        }
    }

}