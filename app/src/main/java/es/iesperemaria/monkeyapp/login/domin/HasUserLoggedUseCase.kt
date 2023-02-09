package es.iesperemaria.monkeyapp.login.domin

import es.iesperemaria.monkeyapp.login.data.LoginRepository
import javax.inject.Inject

class HasUserLoggedUseCase @Inject constructor(private val repository: LoginRepository) {
    suspend operator fun invoke() = repository.isUserConnected()
}