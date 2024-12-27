package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;

public class CadastroSemSucessoTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @DisplayName("Dado que eu realize um cadastro com sucesso")
    @Test

    public void RegistrarNovoUsuarioComDadosErrados() {

//DADO QUE EU REALIZE O CADASTRO NA PAGINA E PREENCHA OS DADOS DO CAMPO
        // Abrir o Chrome

        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

        //Clicar no campo Email
        driver.findElement(By.id("email_create")).click();
        //digitar o email
        driver.findElement(By.id("email_create")).sendKeys("maria.clara@emailfake.com");
        // clicar no botao Create
        driver.findElement(By.id("SubmitCreate")).click();


//QUANDO ELES  NAO SAO PREENCHIDOS CORRETAMENTE

        //Clicar no Title id_gender1
        driver.findElement(By.id("id_gender2")).click();
        //Clicar First Name customer_firstname
        driver.findElement(By.id("customer_firstname")).click();
        //Digitar nome customer_firstname
        driver.findElement(By.id("customer_firstname")).sendKeys("Maria");
        // clicar LastName customer_lastname
        driver.findElement(By.id("customer_lastname")).click();
        //Digitar LastName   customer_lastname
        driver.findElement(By.id("customer_lastname")).sendKeys("Clara");
        // Clicar Password passwd
        driver.findElement(By.id("passwd")).click();
        //Digitar senha passwd
        driver.findElement(By.id("passwd")).sendKeys("1A");
        //Clicar em dia uniform-days

        WebElement daysDropdown = driver.findElement(By.id("days"));
        Select selectDay = new Select(daysDropdown);
        selectDay.selectByValue("20");



        //clicar mes  uniform-months
        WebElement monthsDropdown = driver.findElement(By.id("months"));
        Select selectMonths = new Select(monthsDropdown);
        selectMonths.selectByValue("5");


        //clicarAno years
        WebElement yearsDropdown = driver.findElement(By.id("years"));
        Select selectYears = new Select(yearsDropdown);
        selectYears.selectByValue("2000");

        //clicar no ckeck newsletter
        driver.findElement(By.id("newsletter")).click();

//ENTAO O CADASTRO NAO DEVERA SER REALIZADO

        // Tirar print de tela
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinoArquivo = new File("screenshot01.png");
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
        String mensagem = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assertions.assertEquals("There is 1 error\n" +
                "passwd is invalid.", mensagem);
    }
}