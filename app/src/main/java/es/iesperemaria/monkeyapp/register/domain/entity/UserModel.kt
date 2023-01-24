package es.iesperemaria.monkeyapp.register.domain.entity

data class UserModel(
    val name: String,
    val surname: String,
    val birthdate: String,
    val genre: String,
    val preferences: List<String>,
    val email: String,
    val phone: String,
    val password: String
)
