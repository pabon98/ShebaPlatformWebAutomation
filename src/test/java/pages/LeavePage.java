package pages;

import org.openqa.selenium.By;

public class LeavePage extends BasePage {
public By empName_locator = By.xpath("//input[@placeholder='Type for hints...']");
public By leaveType_locator = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']");
public By fromDate_locator = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]");
public By toDate_Locator = By.cssSelector("div[class='oxd-layout-context'] div:nth-child(2) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) input:nth-child(1)");
public By commentBox_locator = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
public String leave_page_url = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList";
public By assign_page_url = By.xpath("//a[normalize-space()='Assign Leave']");
public By Assign_btn_locator = By.xpath("//button[normalize-space()='Assign']");
public By confirm_leave_btn_locator = By.xpath("//button[normalize-space()='Ok']");
public By toast_message = By.xpath("//div[@id='oxd-toaster_1']");

 public void gotoLeavePage(){
     LoadAnWebpage(leave_page_url);
 }
}
