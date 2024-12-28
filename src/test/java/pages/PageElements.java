package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElements {
    protected WebDriver driver;

    @FindBy(css = ".alert.alert-success")
    public WebElement successMessage;

    @FindBy(css = ".alert.alert-danger")
    public WebElement errorMessage;

    @FindBy(id = "email_create")
    public WebElement emailField;

    @FindBy(id = "SubmitCreate")
    public WebElement createButton;

    @FindBy(id = "id_gender1")
    public WebElement genderMale;

    @FindBy(id = "id_gender2")
    public WebElement genderFemale;

    @FindBy(id = "customer_firstname")
    public WebElement firstName;

    @FindBy(id = "customer_lastname")
    public WebElement lastName;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy(id = "days")
    public WebElement daysDropdown;

    @FindBy(id = "months")
    public WebElement monthsDropdown;

    @FindBy(id = "years")
    public WebElement yearsDropdown;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheckbox;

    @FindBy(id = "submitAccount")
    public WebElement submitAccountButton;

    public PageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
