package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroPage extends PageElements {

    public CadastroPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    public void fillForm(String email, String firstName, String lastName, String password) {
        emailField.sendKeys(email);
        createButton.click();
        genderFemale.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.password.sendKeys(password);
        new Select(daysDropdown).selectByValue("20");
        new Select(monthsDropdown).selectByValue("5");
        new Select(yearsDropdown).selectByValue("2000");
        newsletterCheckbox.click();
    }

    public void submitForm() {
        submitAccountButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
