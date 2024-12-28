package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContatoPage extends PageElements {

    @FindBy(id = "contact-link")
    public WebElement contactLink;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "id_contact")
    public WebElement subjectDropdown;

    @FindBy(id = "id_order")
    public WebElement orderField;

    @FindBy(id = "message")
    public WebElement messageField;

    @FindBy(id = "fileUpload")
    public WebElement fileUpload;

    @FindBy(id = "submitMessage")
    public WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    public WebElement printText;

    public ContatoPage(WebDriver driver) {
        super(driver);
    }

    public void sendContactForm(String email, String order, String message) {
        contactLink.click();
        new Select(subjectDropdown).selectByValue("2");
        emailField.sendKeys(email);
        orderField.sendKeys(order);
        messageField.sendKeys(message);
    }

    public void attachFile(String filePath) {
        fileUpload.sendKeys(filePath);
    }

    public void submitForm() {
        submitButton.click();
    }

    public String getSuccessMessage() {
       return printText.getText();

    }
}
