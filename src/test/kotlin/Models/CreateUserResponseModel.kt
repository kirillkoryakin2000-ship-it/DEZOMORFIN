package Models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class CreateUserResponseModel(
    var id: Int = 0,
    var name: String? = null,
    var job: String? = null
)