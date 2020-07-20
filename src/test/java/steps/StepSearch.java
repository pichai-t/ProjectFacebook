package steps;

import base.BaseUtil;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.FirstPage;
import pages.LoginPage;
import resources.Account;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class StepSearch {
    private static LoginPage loginPage;
    private static FirstPage firstPage;
    WebDriver driver;

    @Given("^a web browser is at the facebook home page$")
    public void aWebBrowserIsAtTheFacebookHomePage() throws IOException {
        BaseUtil.getDriver().navigate().to(BaseUtil.url);

        Reader freader = new FileReader(BaseUtil.fileAccount);
        HeaderColumnNameMappingStrategy<Account> beanStrategy = new HeaderColumnNameMappingStrategy<Account>();
        beanStrategy.setType(Account.class);

        CsvToBean<Account> csvToBean = new CsvToBeanBuilder<Account>(freader)
                .withType(Account.class)
                .withIgnoreLeadingWhiteSpace(true)
                .withMappingStrategy(beanStrategy)
                .build();
        // reads all “Account”s – entire file - into a list of Account beans
        List<Account> accounts = csvToBean.parse();
        loginPage = new LoginPage();
        for (Account user : accounts) {
            LoginPage.inputUsernameAndPassword(user.getUsername(), user.getPassword());
        }
        loginPage.clickBtnSignin();
        freader.close();
    }
    @When("^the user enters keyword into the search bar$")
    public void theUserEntersTesterIntoTheSearchBar() {
        firstPage = new FirstPage();
        firstPage.inputKeywordOnSearchBar();
        firstPage.clickSearchBtn();
    }
    @Then("^links related to keyword are shown on the results page$")
    public void linksRelatedToTesterAreShownOnTheResultsPage() {
        firstPage = new FirstPage();
        firstPage.checkCompareText();
    }
}
