import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeAll

open class TestBase {

    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            RestAssured.baseURI = "https://reqres.in"
            RestAssured.basePath = "/api"
        }
    }
}