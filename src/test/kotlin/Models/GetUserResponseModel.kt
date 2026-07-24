package models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetUserResponseModel(
    var data: DataObject? = null
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class DataObject(
        var id: Int = 0,
        var email: String? = null,
        var first_name: String? = null,
        var last_name: String? = null,
        var avatar: String? = null
    )
}