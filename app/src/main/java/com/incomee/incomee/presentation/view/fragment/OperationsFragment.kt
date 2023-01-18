package com.incomee.incomee.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.incomee.incomee.R
import com.incomee.incomee.data.constants.OperationType
import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.presentation.utils.Extensions.toComaString
import com.incomee.incomee.presentation.utils.Views.showDialog
import com.incomee.incomee.presentation.view.dialog.OnDialogCloseI
import com.incomee.incomee.presentation.view.dialog.OperationTypeDialog
import com.incomee.incomee.presentation.viewmodel.OperationsViewModel
import com.incomee.incomee.presentation.viewmodel.factory.OperationsViewModelFactory

class OperationsFragment : Fragment(R.layout.fragment_operations), OnDialogCloseI {

    private lateinit var vm: OperationsViewModel

    private lateinit var operationTypeFilterButton: LinearLayout
    private lateinit var operationTypeFilterTextView: TextView
    private lateinit var operationTypeFilterIcon: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_operations, container, false)

        operationTypeFilterButton = view.findViewById(R.id.operationTypeFilterButton)
        operationTypeFilterTextView = view.findViewById(R.id.operationTypeFilterTextView)
        operationTypeFilterIcon = view.findViewById(R.id.operationTypeFilterIcon)

        vm = ViewModelProvider(this, OperationsViewModelFactory(requireContext()))
            .get(OperationsViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpFilters()

        vm.operationTypeFilters.observe(viewLifecycleOwner, Observer {
            setUpOperationTypeFilterText(it)
        })

        operationTypeFilterButton.setOnClickListener {
            showDialog(OperationTypeDialog(), childFragmentManager, this)
        }

        operationTypeFilterIcon.setOnClickListener {
            operationTypeFilterIconOnClick()
        }

    }

    private fun operationTypeFilterIconOnClick() {
        if (operationTypeFilterButton.isActivated) {
            vm.updateOperationTypeFilters()
            setUpOperationTypeFilter()
        } else showDialog(OperationTypeDialog(), childFragmentManager, this)
    }

    override fun onDialogClose() {
        setUpFilters()
    }

    private fun setUpFilters() {
        setUpOperationTypeFilter()
    }

    private fun setUpOperationTypeFilter() {
        vm.getOperationTypeFilters()
        setUpOperationTypeFilterActivation()
    }

    private fun setUpOperationTypeFilterActivation() {
        operationTypeFilterButton.isActivated =
            vm.operationTypeFilters.value?.size != OperationType.values().size
    }

    private fun setUpOperationTypeFilterText(it: List<OperationTypeFilter>) {
        if (vm.operationTypeFilters.value?.size == OperationType.values().size) {
            operationTypeFilterTextView.text = getString(R.string.operation_type_title)
        } else operationTypeFilterTextView.text = it.toComaString()
    }

}