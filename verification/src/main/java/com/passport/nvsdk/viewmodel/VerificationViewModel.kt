package com.passport.nvsdk.viewmodel

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VerificationViewModel : ViewModel() {

    val _result = MutableLiveData<StateResult>()
    val result: LiveData<StateResult> = _result

    fun verifyOtp(otp: String) {
        _result.value = StateResult.LOADING
        AsyncTask.execute {
            Thread.sleep(3000)
            _result.postValue(StateResult.SUCCESS)
        }
    }

}


enum class StateResult {
    SUCCESS,
    LOADING,
}