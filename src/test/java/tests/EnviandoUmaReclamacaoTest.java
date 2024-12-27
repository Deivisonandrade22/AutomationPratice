
package tests;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.apache.commons.io.FileUtils;
        import org.junit.jupiter.api.*;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.Select;

        import java.io.File;
        import java.time.Duration;

public class EnviandoUmaReclamacaoTest {
    private WebDriver driver;
    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @DisplayName("Enviando um contato a loja")
    @Test
    public void EnviandoProdutoParaUmAmigo(){
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");


//DADO  QUE EU ENVIE UM CONTATO NO SITE


        // clicar na  contact us
        driver.findElement(By.id("contact-link")).click();
//QUANDO OS DADOS SAO PREENCHIDOS
        // Selecionar o vestido
        WebElement dropdown = driver.findElement(By.id("id_contact"));
        Select option = new Select(dropdown);
        option.selectByValue("2");
        //Email
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("paulo.souza@emailfake.com");

        //Order
        driver.findElement(By.id("id_order")).click();
        driver.findElement(By.id("id_order")).sendKeys("Entrega");

        //mensagem
        driver.findElement(By.id("message")).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse maximus ut arcu non fermentum. Curabitur faucibus varius erat, et imperdiet neque lacinia ut. Praesent rhoncus nulla a metus vehicula blandit.");

        //anexando arquivo
        // Localiza o campo de upload de arquivo
        WebElement fileInput = driver.findElement(By.id("fileUpload"));

        // Envia o caminho absoluto do arquivo para o campo
        fileInput.sendKeys("/Users/deivison/Documents/DTI/AutomationPractice/envio.txt");//Para funcionar precisa ter esse arquivo modelo e colocar o caminho da sua maquina



        // Tirar print de tela
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinoArquivo = new File("screenshot02.png");
        try {
            // Copiar o arquivo para o destino
            FileUtils.copyFile(screenshot, destinoArquivo);
            System.out.println("Screenshot salvo em: " + destinoArquivo.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Erro ao salvar o screenshot: " + e.getMessage());
            e.printStackTrace();
        }


// ENTAO O FORMULÁRIO É ENVIADO
        // Enviar mensagem
        driver.findElement(By.id("submitMessage")).click();

        String mensagem = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assertions.assertEquals("Your message has been successfully sent to our team.", mensagem);
    }

}