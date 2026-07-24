package helpers

import io.qameta.allure.restassured.AllureRestAssured

object AllureListener {

    object CustomAllureListener {
        private val filter = AllureRestAssured()

        fun withCustomTemplates(): AllureRestAssured {
            filter.setRequestTemplate("request.ftl")
            filter.setResponseTemplate("response.ftl")
            return filter
        }
    }
}