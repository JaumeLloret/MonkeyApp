package es.iesperemaria.monkeyapp.login.domin

import es.iesperemaria.monkeyapp.login.data.LoginRepository
import javax.inject.Inject

class HasTokenUseCase @Inject constructor(private val repository: LoginRepository) {
    suspend operator fun invoke(): Boolean = repository.getConnectionToken()
}