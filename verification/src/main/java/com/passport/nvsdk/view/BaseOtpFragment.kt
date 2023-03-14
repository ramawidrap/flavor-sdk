package com.passport.nvsdk.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.passport.nvsdk.R
import com.passport.nvsdk.viewmodel.StateResult
import com.passport.nvsdk.viewmodel.VerificationViewModel

abstract class BaseOtpFragment : Fragment() {

    val viewModel: VerificationViewModel by lazy {
        ViewModelProvider(this).get(VerificationViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.result.observe(viewLifecycleOwner) {
            when (it) {
                StateResult.LOADING -> {
                    onLoading()
                }

                StateResult.SUCCESS -> {
                    onSuccessVerify()
                }
            }
        }
    }

    abstract fun onLoading()

    abstract fun onSuccessVerify()

}