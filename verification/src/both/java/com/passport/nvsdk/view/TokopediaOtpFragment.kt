package com.passport.nvsdk.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.passport.nvsdk.databinding.TokopediaFragmentOtpBinding


class TokopediaOtpFragment : BaseOtpFragment() {

    private var _binding: TokopediaFragmentOtpBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = TokopediaFragmentOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pin.isPasswordHidden = true
        binding.add.setOnClickListener {
            viewModel.verifyOtp(binding.pin.text?.toString() ?: "")
        }
    }

    override fun onLoading() {
        binding.add.startAnimation()
    }

    override fun onSuccessVerify() {
        binding.add.revertAnimation()
        Toast.makeText(requireContext(), "Success Verify Pin", Toast.LENGTH_LONG).show()    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}