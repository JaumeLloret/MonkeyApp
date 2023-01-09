package com.jle.monkeyfilmapp.register.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jle.monkeyfilmapp.register.domin.usecases.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerUseCase: RegisterUseCase) :ViewModel() {

    private val _phone = MutableLiveData<String>()
    val phone : LiveData<String> = _phone

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword : LiveData<String> = _confirmPassword

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private val _surname = MutableLiveData<String>()
    val surname : LiveData<String> = _surname

    private val _birthdate = MutableLiveData<String>()
    val birthdate : LiveData<String> = _birthdate

    private val _genre = MutableLiveData<String>()
    val genre : LiveData<String> = _genre

    private val _preferences = MutableLiveData<List<String>>()
    val preferences : LiveData<List<String>> = _preferences

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable:LiveData<Boolean> = _isLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading:LiveData<Boolean> = _isLoading

    fun onLoginChanged(email:String, password:String){
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    private fun enableLogin(email: String, password: String) =
        Patterns.PHONE.matcher(email).matches() && password.length > 6

    fun onLoginClick() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = registerUseCase(email.value!!, password.value!!)
            Log.i("DAM", "Se ha completado el envio de datos y es: $result")
            if(result) {
                Log.i("DAM", "Se ha completado el envio de datos")
            }
            _isLoading.value = false
        }
    }
}