package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
 public String loginPage_url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
 public String userName = "Admin";
 public String password = "admin123";
 public By userName_locator = By.xpath("//input[@placeholder='Username']");
 public By passWord_locator = By.xpath("//input[@placeholder='Password']");
 public By login_locator = By.cssSelector("button[type='submit']");
 public By dashboard_text_locator = By.xpath("//a[@class='oxd-main-menu-item active']");
 public String dashboard_text = "Dashboard";
 public By logout_locator = By.xpath("//a[normalize-space()='Logout']");
 public By logout_arrowDown_icon = By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon");


    public void navigateToLoginPage(){
     LoadAnWebpage(loginPage_url);
    }
}


