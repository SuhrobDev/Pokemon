package uz.rounded.domain.model


data class UserProfile(
    val _id: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val student_code: String,
    val address: String,
    val imgUrl: String,
    val birthDate: String,
    val gender: String,
    val email: String,
    val status: String,
    val balance: Int,
    val vocabularyCount: Int,
    val score: Int,
    val createdAt: String,
    val password: String = "",
    val token: String
)