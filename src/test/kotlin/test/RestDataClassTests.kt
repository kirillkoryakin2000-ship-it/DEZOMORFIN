package tests
import Models.CreateUserBodyModel
import Models.CreateUserResponseModel
import TestBase
import helpers.step
import io.restassured.RestAssured.given
import models.GetUserResponseModel
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import specs.ReqresSpec.createdResponseSpec
import specs.ReqresSpec.noContentResponseSpec
import specs.ReqresSpec.okResponseSpec
import specs.ReqresSpec.requestSpec


class ReqresTests : TestBase() {

    @DisplayName("Check that user data are received")
    @Tag("API")
    @Test
    fun fetchUserInfoTest() {
        val httpResponse: GetUserResponseModel = step("Fetch user data") {
            given(requestSpec)
                .`when`()
                .get("users/{id}", 1)
                .then()
                .spec(okResponseSpec)
                .extract().`as`(GetUserResponseModel::class.java)
        }

        step("Check that id is equal to expected value") {
            assertThat(httpResponse.data?.id, equalTo(1))
        }
        step("Check that first_name = George") {
            assertThat(httpResponse.data?.first_name, equalTo("George"))
        }
        step("Check that email = george.bluth@reqres.in") {
            assertThat(httpResponse.data?.email, equalTo("george.bluth@reqres.in"))
        }
    }

    @DisplayName("Check that new user can be created")
    @Tag("API")
    @Test
    fun createNewUserTest() {
        val user = CreateUserBodyModel(name = "Vlad", job = "QA")

        val httpResponse: CreateUserResponseModel = step("Create new user") {
            given(requestSpec)
                .body(user)
                .`when`()
                .post("/users/")
                .then()
                .spec(createdResponseSpec)
                .extract().`as`(CreateUserResponseModel::class.java)
        }

        step("Check that name equal to name from request") {
            assertThat(httpResponse.name, equalTo(user.name))
        }
        step("Check that job equal to job from request") {
            assertThat(httpResponse.job, equalTo(user.job))
        }
        step("Check that id is not null") {
            assertThat(httpResponse.id, notNullValue())
        }

        given(requestSpec).delete("users/" + httpResponse.id)
    }

    @DisplayName("Check that user can be deleted")
    @Tag("API")
    @Test
    fun deleteUserTest() {
        val user = CreateUserBodyModel(name = "Ivan", job = "DevOps")

        val httpResponse: CreateUserResponseModel = step("Create new user") {
            given(requestSpec)
                .body(user)
                .`when`()
                .post("/users/")
                .then()
                .spec(createdResponseSpec)
                .extract().`as`(CreateUserResponseModel::class.java)
        }

        val deletedRes: String = step("Delete created user") {
            given(requestSpec)
                .delete("users/" + httpResponse.id)
                .then()
                .spec(noContentResponseSpec)
                .extract().asString()
        }

        println(deletedRes)

        step("Check that empty response body is returned") {
            assertThat(deletedRes, equalTo(""))
        }
    }
}