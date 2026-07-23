package specs

import helpers.AllureListener.CustomAllureListener.withCustomTemplates
import io.restassured.RestAssured.with
import io.restassured.builder.ResponseSpecBuilder
import io.restassured.filter.log.LogDetail.ALL
import io.restassured.http.ContentType.JSON
import io.restassured.specification.RequestSpecification
import io.restassured.specification.ResponseSpecification

object ReqresSpec {

    val requestSpec: RequestSpecification = with()
        .filter(withCustomTemplates())
        .contentType(JSON)
        .log().all()

    val createdResponseSpec: ResponseSpecification = ResponseSpecBuilder()
        .expectStatusCode(201)
        .log(ALL)
        .build()


    val okResponseSpec: ResponseSpecification = ResponseSpecBuilder()
        .expectStatusCode(200)
        .log(ALL)
        .build()

    val noContentResponseSpec: ResponseSpecification = ResponseSpecBuilder()
        .expectStatusCode(204)
        .log(ALL)
        .build()
}