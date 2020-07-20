package pages;

import base.BaseUtil;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstPage {
    public FirstPage() {
        PageFactory.initElements(BaseUtil.getDriver(), this);

    }
    @FindBy(how = How.NAME, using= "q")
    private static WebElement searchTextField;

    public static void inputKeywordOnSearchBar(){
        BaseUtil.getWaiter().until(ExpectedConditions.visibilityOf(searchTextField));
        searchTextField.sendKeys("Keyword Tool");
    }
    @FindBy(how = How.CLASS_NAME, using="_585_")
    private static WebElement seachBtn;

    public static void clickSearchBtn(){
        BaseUtil.getWaiter().until(ExpectedConditions.visibilityOf(seachBtn));
        seachBtn.submit();
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"xt_uniq_1\"]/div[1]/div/div[1]/div[1]/div[1]/a")
    private static WebElement checkText;
    public static void checkCompareText(){
        BaseUtil.getWaiter().until(ExpectedConditions.visibilityOf(checkText));
        Assert.assertEquals(checkText.getText(), "Keyword Tool");
    }
}
