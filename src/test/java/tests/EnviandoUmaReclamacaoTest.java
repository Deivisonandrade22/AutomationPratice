package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ContatoPage;

public class EnviandoUmaReclamacaoTest extends BaseTest {


    //DADO QUE  REALIZE UM CONTATO COM A LOJA
    @DisplayName("Enviando um contato à loja")
    @Test
    public void EnviandoProdutoParaUmAmigo() {
        ContatoPage contatoPage = new ContatoPage(driver);
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

    //E PREENCHA OS DADOS NOS CAMPOS CORRESPODENTES   E CLIQUE EM ENVIAR
        contatoPage.sendContactForm("paulo.souza@emailfake.com", "Entrega", "Lorem ipsum dolor sit amet...");
        contatoPage.attachFile("/Users/deivison/Documents/DTI/AutomationPractice/envio.txt");
        contatoPage.submitForm();

    //ENTAO O FORMULÁRIO É ENVIADO COM SUCESSO
        Assertions.assertEquals("Your message has been successfully sent to our team.", contatoPage.getSuccessMessage());
    }
}
