package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by ptangtro on 7/20/2020.
 */
@CucumberOptions(
        features={"src\\test\\java\\features\\"},
        glue= {"steps"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"},
        monochrome = true
)

public class Runner  extends AbstractTestNGCucumberTests {

  // TODO



}


