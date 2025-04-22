package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.LeavePage;
import pages.LoginPage;
import utilities.DriverSetUp;

import java.time.Duration;
import java.util.List;

public class TestLeavePage extends DriverSetUp {
    LeavePage leavePage = new LeavePage();
    @Test
    public void setUpClass()  {
        leavePage.gotoLeavePage();
        leavePage.clickOneElement(leavePage.assign_page_url);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(leavePage.assign_page_url, "Assign Leave"));
    }
    @Test
    public void assignLeaveWithValidData() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        // Employee Name
        leavePage.writeOneElement(leavePage.empName_locator, "Timothy Lewis Amiano");
        Thread.sleep(2000);
        actions.moveToElement(leavePage.getElement(leavePage.empName_locator)).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        // Leave Type
        leavePage.clickOneElement(leavePage.leaveType_locator);
        WebDriverWait leaveWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        List<WebElement> options = leaveWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@role='listbox']//div[contains(@class, 'oxd-select-option')]")
        ));
        if(options.size() >=2){
            options.get(1).click();
        }
        else {
            System.out.println("Less than 2 options found!");
        }

        // FROM DATE
         leavePage.writeOneElement(leavePage.fromDate_locator, "2025-25-04");

        //TO DATE
       // leavePage.writeOneElement(leavePage.toDate_Locator, "2025-28-04");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        // TO DATE
        js.executeScript("arguments[0].value='2025-28-04';", getDriver().findElement(leavePage.toDate_Locator));
        Thread.sleep(2000);

        // COMMENT BOX
        leavePage.writeOneElement(leavePage.commentBox_locator, "I need leave for two days");

        leavePage.clickOneElement(leavePage.Assign_btn_locator);
        Thread.sleep(2000);
        leavePage.clickOneElement(leavePage.confirm_leave_btn_locator);
//        Thread.sleep(4000);
        // Wait for toast success message
        WebDriverWait toastMessageWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        toastMessageWait.until(ExpectedConditions.textToBePresentInElement(leavePage.getElement(leavePage.toast_message), "Success"));


    }

}
