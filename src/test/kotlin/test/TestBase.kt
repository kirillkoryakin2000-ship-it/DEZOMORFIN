package test

import com.codeborne.selenide.Configuration
import org.junit.jupiter.api.BeforeAll

open class TestBase {
    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            Configuration.pageLoadStrategy = "eager"
            Configuration.browserSize = "1920x1080"
            Configuration.holdBrowserOpen = true
        }
    }
}