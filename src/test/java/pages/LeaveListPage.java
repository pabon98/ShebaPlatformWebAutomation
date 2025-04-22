package pages;
import org.openqa.selenium.By;

public class LeaveListPage extends BasePage{
    public By Emp_name_locator =By.xpath("//input[@placeholder='Type for hints...']");
    public By showLeaveStatus_locator = By.xpath("//div[@class='oxd-multiselect-wrapper']//div[@class='oxd-select-text oxd-select-text--active']");
    public String LeaveListPageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList";
    public By leave_list_menu_locator = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Leave']");
    public By search_btn_locator = By.xpath("//button[normalize-space()='Search']");
    public By record_found_txt_locator = By.xpath("//span[@class='oxd-text oxd-text--span']");
    public void gotoLeaveListPage(){
        LoadAnWebpage(LeaveListPageUrl);
    }
}
