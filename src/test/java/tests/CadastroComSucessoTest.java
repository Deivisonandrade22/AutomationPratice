import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;

public class CadastroComSucessoTest {
    private WebDriver driver;
    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @DisplayName("Dado que eu realize um cadastro com sucesso")
    @Test

    public void RegistrarNovoUsuarioComDadosValidos(){

        //DADO QUE EU REALIZE O CADASTRO NA PAGINA E PREENCHA OS DADOS DO CAMPO
        // Abrir o Chrome

        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

        //Clicar no campo Email
        driver.findElement(By.id("email_create")).click();
        //digitar o email
        driver.findElement(By.id("email_create")).sendKeys("carlos.augusto06@emailfake.com");
        // clicar no botao Create
        driver.findElement(By.id("SubmitCreate")).click();



//QUANDO ELES SAO PREENCHIDOS CORRETAMENTE

        //Clicar no Title id_gender1
        driver.findElement(By.id("id_gender1")).click();
        //Clicar First Name customer_firstname
        driver.findElement(By.id("customer_firstname")).click();
        //Digitar nome customer_firstname
        driver.findElement(By.id("customer_firstname")).sendKeys("Carlos");
        // clicar LastName customer_lastname
        driver.findElement(By.id("customer_lastname")).click();
        //Digitar LastName   customer_lastname
        driver.findElement(By.id("customer_lastname")).sendKeys("Augusto");
        // Clicar Password passwd
        driver.findElement(By.id("passwd")).click();
        //Digitar senha passwd
        driver.findElement(By.id("passwd")).sendKeys("123456");
        //Clicar em dia uniform-days
        WebElement daysDropdown = driver.findElement(By.id("days"));
        Select selectDay = new Select(daysDropdown);
        selectDay.selectByValue("12");



        //clicar mes  uniform
        WebElement monthsDropdown = driver.findElement(By.id("months"));
        Select selectMonths = new Select(monthsDropdown);
        selectMonths.selectByValue("9");


        //clicarAno years
        WebElement yearsDropdown = driver.findElement(By.id("years"));
        Select selectYears = new Select(yearsDropdown);
        selectYears.selectByValue("1998");

        //clicar no ckeck newsletter
        driver.findElement(By.id("newsletter")).click();

//ENTAO O CADASTRO DEVERA SER REALIZADO COM SUCESSO

        // tirar print de tela
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinoArquivo = new File("screenshot.png");
        try {
            // Copiar o arquivo para o destino
            FileUtils.copyFile(screenshot, destinoArquivo);
            System.out.println("Screenshot salvo em: " + destinoArquivo.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Erro ao salvar o screenshot: " + e.getMessage());
            e.printStackTrace();
        }

        //clicar no botao Register submitAccount
        driver.findElement(By.id("submitAccount")).click();

        //validar essa mensagem  usar o visible  Your account has been created.
        String mensagem = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assertions.assertEquals("Your account has been created.", mensagem);




    }

}

