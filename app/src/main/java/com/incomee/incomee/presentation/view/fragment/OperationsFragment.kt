package com.incomee.incomee.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.incomee.incomee.R
import com.incomee.incomee.data.constants.DialogConstants
import com.incomee.incomee.data.constants.DialogConstants.TAG
import com.incomee.incomee.presentation.utils.Utils.toComaString
import com.incomee.incomee.presentation.view.dialog.OperationTypeDialog
import com.incomee.incomee.presentation.viewmodel.OperationsViewModel
import com.incomee.incomee.presentation.viewmodel.factory.OperationsViewModelFactory

class OperationsFragment : Fragment(R.layout.fragment_operations), OperationTypeDialog.OnDialogCloseI {

    private lateinit var vm: OperationsViewModel

    private val dialog: OperationTypeDialog by lazy { OperationTypeDialog() }
    private lateinit var operationTypeFilterButton: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_operations, container, false)

        operationTypeFilterButton = view.findViewById(R.id.operationTypeFilterButton)

        vm = ViewModelProvider(this, OperationsViewModelFactory(requireContext()))
            .get(OperationsViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.operationTypeFilters.observe(viewLifecycleOwner, Observer {
            operationTypeFilterButton.text = it.toComaString()
        })

        operationTypeFilterButton.setOnClickListener {
            dialog.show(childFragmentManager, TAG)
            dialog.initOnDialogCloseI(this)
        }

    }

    override fun onDialogClose() {
        onResume()
    }

    override fun onResume() {
        super.onResume()
        vm.getOperationTypeFilters()
        operationTypeFilterButton.isActivated =
            vm.operationTypeFilters.value?.size != DialogConstants.OPERATION_TYPES.size
    }

}