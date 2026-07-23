import io.restassured.RestAssured.given
import io.restassured.http.ContentType.JSON
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RegressApiTests : TestBase() {

    @Test
    @DisplayName("Успешная регистрация пользователя")
    fun successfulRegistrationTest() {
        val registrationData = """{"email": "eve.holt@reqres.in", "password": "pistol"}"""

        given()
            .body(registrationData)
            .contentType(JSON)
            .log().uri()
            .`when`()
            .post("/register")
            .then()
            .log().status()
            .log().body()
            .statusCode(200)
            .body("token", notNullValue())
    }

    @Test
    @DisplayName("Неуспешное получение пользователя по id")
    fun getNonexistentUserTest() {
        given()
            .log().uri()
            .`when`()
            .get("/users/30")
            .then()
            .log().status()
            .log().body()
            .statusCode(404)
    }

    @Test
    @DisplayName("Успешное удаление пользователя")
    fun deleteUserTest() {
        given()
            .log().all()
            .`when`()
            .delete("api/users/2")
            .then()
            .log().status()
            .log().body()
            .statusCode(204)
    }
}