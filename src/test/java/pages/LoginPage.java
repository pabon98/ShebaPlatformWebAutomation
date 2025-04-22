package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
 public String loginPage_url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
 public String userName = "Admin";
 public String password = "admin123";
 public By userName_locator = By.xpath("//input[@placeholder='Username']");
 public By passWord_locator = By.xpath("//input[@placeholder='Password']");
 public By login_locator = By.cssSelector("button[type='submit']");
 public By dashboard_userName_locator = By.xpath("//p[@class='oxd-userdropdown-name']");
 public String dashboard_username = "Arthur Ghamboyan";


    public void navigateToLoginPage(){
     LoadAnWebpage(loginPage_url);
    }
}


