package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.LeaveListPage;
import pages.LoginPage;
import utilities.DriverSetUp;

import java.time.Duration;
import java.util.List;

public class TestLeaveListPage extends DriverSetUp {
    LeaveListPage leaveListPage = new LeaveListPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void setUpLeaveListPage() throws InterruptedException {
        leaveListPage.gotoLeaveListPage();
        WebDriverWait leaveWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        leaveWait.until(ExpectedConditions.textToBePresentInElementLocated(leaveListPage.leave_list_menu_locator, "Leave"));

    }
    @Test
    public void searchLeaveList() throws InterruptedException {
        // Emp name
        leaveListPage.writeOneElement(leaveListPage.Emp_name_locator, "Timothy Lewis Amiano");
        Actions leaveEmployeeAction = new Actions(getDriver());
        Thread.sleep(2000);
        leaveEmployeeAction.moveToElement(leaveListPage.getElement(leaveListPage.Emp_name_locator)).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        //Leave with status select box
        leaveListPage.clickOneElement(leaveListPage.showLeaveStatus_locator);
        WebDriverWait listOptionsWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        List<WebElement> options = listOptionsWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='listbox']//div[contains(@class, 'oxd-select-option')]")));

        if (options.size() >= 3){
           options.get(3).click();
        }
        else {
            System.out.println("Not enough options in dropdown");
        }
//        Thread.sleep(3000);
        leaveListPage.clickOneElement(leaveListPage.search_btn_locator);
        WebDriverWait recordFoundWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        recordFoundWait.until(ExpectedConditions.textToBePresentInElementLocated(leaveListPage.record_found_txt_locator, "(1) Record Found"));
    }


    @AfterClass
    public void logOutUser() throws InterruptedException {
        loginPage.clickOneElement(loginPage.logout_arrowDown_icon);
        loginPage.clickOneElement(loginPage.logout_locator);
        Thread.sleep(2000);

    }

}
