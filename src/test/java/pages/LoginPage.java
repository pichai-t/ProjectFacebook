package pages;

import base.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(BaseUtil.getDriver(), this);
    }
    @FindBy(how = How.ID, using = "email")
    private static WebElement emailTextField;

    @FindBy(how = How.ID, using = "pass")
    private static WebElement passTextField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"u_0_b\"]")
    private static WebElement signinBtn;

    public static void inputUsernameAndPassword(String username,String password){
        BaseUtil.getWaiter().until(ExpectedConditions.visibilityOf(emailTextField));
        emailTextField.sendKeys(username);
        BaseUtil.getWaiter().until(ExpectedConditions.visibilityOf(passTextField));
        passTextField.sendKeys(password);
    }
    public void clickBtnSignin(){
        BaseUtil.getWaiter().until(ExpectedConditions.visibilityOf(signinBtn));
        signinBtn.click();
    }
}
