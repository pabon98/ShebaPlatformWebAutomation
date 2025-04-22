package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DriverSetUp;

import java.time.Duration;

public class TestLoginPage extends DriverSetUp {
    LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void setupClass(){
     loginPage.navigateToLoginPage();
    }
    @Test
    public void LoginWithValidCredentials()  {
    loginPage.writeOneElement(loginPage.userName_locator, loginPage.userName);
    loginPage.writeOneElement(loginPage.passWord_locator, loginPage.password);
    loginPage.clickOneElement(loginPage.login_locator);
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    wait.until(ExpectedConditions.textToBePresentInElementLocated(loginPage.dashboard_text_locator, loginPage.dashboard_text ));

    }
}
