package es.iesperemaria.monkeyapp.login.domin

import es.iesperemaria.monkeyapp.login.data.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository){

    suspend operator fun invoke(user: String, password: String) : Boolean {
        return if (repository.getConnectionToken()) {
            true
        }
        else
            repository.doLogin(user, password)
    }
}