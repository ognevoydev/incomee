package com.incomee.incomee.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.clearFragmentResult
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.incomee.incomee.R

class OperationsFragment : Fragment(R.layout.fragment_operations) {

    private lateinit var vm: OperationsViewModel

    private lateinit var addOperationFab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_operations, container, false)

        addOperationFab = view.findViewById(R.id.AddOperationFab)

        vm = ViewModelProvider(this, OperationsViewModelFactory())
            .get(OperationsViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("AAA", "Fragment created")

//        vm.result.observe(this, Observer {
//            someView.text = it
//        })

        addOperationFab.setOnClickListener {
//            vm.addOperation(operation)
        }

    }


}