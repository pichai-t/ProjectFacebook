package steps;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {
    @Before(order = 0)
    public void beforeTest(Scenario scenario) {
        System.out.println("-----------------Start of Scenario: " + scenario.getName() + "-----------------");
        BaseUtil.initialize("Chrome", 1, 10);
    }

    @After(order=0)
    public void tearDownTest(Scenario scenario) throws Exception {
        System.out.println("### TearDown ###");

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) BaseUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        BaseUtil.removeDriver();
        System.out.println("-----------------End of Scenario-----------------");
    }
}
