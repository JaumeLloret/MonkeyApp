package es.iesperemaria.monkeyapp.register.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.iesperemaria.monkeyapp.register.domain.entity.UserModelFactory
import es.iesperemaria.monkeyapp.register.domain.usecase.RegisterUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val userModelFactory: UserModelFactory
) :
    ViewModel() {

    private val _phone = MutableLiveData<String>()
    val phone: LiveData<String> = _phone

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _surname = MutableLiveData<String>()
    val surname: LiveData<String> = _surname

    private val _birthdate = MutableLiveData<String>()
    val birthdate: LiveData<String> = _birthdate

    private val _genre = MutableLiveData<String>()
    val genre: LiveData<String> = _genre

    private val _preferences = MutableLiveData<List<String>>()
    val preferences: LiveData<List<String>> = _preferences

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onRegisterChanged(
        name: String,
        surname: String,
        phone: String,
        genre: String,
        email: String,
        birthdate: String,
        password: String,
        confirmPassword: String
    ) {
        _name.value = name
        _surname.value = surname
        _phone.value = phone
        _genre.value = genre
        _birthdate.value = birthdate
        _email.value = email
        _confirmPassword.value = confirmPassword
        _password.value = password
        _isLoginEnable.value = enableRegisterButton(
            name,
            surname,
            phone,
            genre,
            email,
            birthdate,
            password,
            confirmPassword
        )
    }

    private fun enableRegisterButton(
        name: String,
        surname: String,
        phone: String,
        genre: String,
        email: String,
        birthdate: String,
        password: String,
        confirmPassword: String
    ) = Patterns.PHONE.matcher(phone).matches()
            && Patterns.EMAIL_ADDRESS.matcher(email).matches()
            && password.length > 6 && password.compareTo(confirmPassword) == 0
            && birthdate.isNotEmpty() && name.isNotEmpty()
            && surname.isNotEmpty() && genre.isNotEmpty()

    fun onRegisterClick() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = registerUseCase(
                userModelFactory(
                    name = name.value!!,
                    surname = surname.value!!,
                    phone = phone.value!!,
                    genre = genre.value!!,
                    email = email.value!!,
                    birthdate = birthdate.value!!,
                    password = password.value!!,
                )
            )
            Log.i("DAM", "Se ha completado el envio de datos y es: $result")
            if (result) {
                Log.i("DAM", "Se ha completado el envio de datos")
            }
            _isLoading.value = false
        }
    }
}