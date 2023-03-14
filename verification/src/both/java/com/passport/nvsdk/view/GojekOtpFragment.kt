package com.passport.nvsdk.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.passport.nvsdk.databinding.GojekFragmentOtpBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GojekOtpFragment : BaseOtpFragment() {

    private var _binding: GojekFragmentOtpBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GojekFragmentOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.add.setOnClickListener {
            viewModel.verifyOtp(binding.pin.value)
        }
    }

    override fun onLoading() {
        binding.add.showLoading()
    }

    override fun onSuccessVerify() {
        binding.add.hideLoading()
        Toast.makeText(requireContext(), "Success Verify Pin", Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}