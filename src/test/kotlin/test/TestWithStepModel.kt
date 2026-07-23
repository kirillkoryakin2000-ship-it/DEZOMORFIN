import StepModelForTest.StepModelForWebTest
import org.junit.jupiter.api.Test

class WebIntrerfaceTest {

    @Test
    fun annotationSearchTest() {
        val tests = StepModelForWebTest()
        tests.openMainPage()
        tests.searchForRepository(tests.getRepository())
        tests.clickOnLinkRepository(tests.getRepository())
        tests.goToIssueTab()
        tests.checkedResults(tests.getNumberIssue())
    }
}