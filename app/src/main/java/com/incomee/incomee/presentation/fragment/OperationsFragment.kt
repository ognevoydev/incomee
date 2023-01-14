package com.incomee.incomee.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.incomee.incomee.R
import com.incomee.incomee.presentation.viewmodel.OperationsViewModel
import com.incomee.incomee.presentation.viewmodel.OperationsViewModelFactory

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

//        vm.result.observe(this, Observer {
//            someView.text = it
//        })

        addOperationFab.setOnClickListener {
//            vm.addOperation(operation)
        }

    }


}