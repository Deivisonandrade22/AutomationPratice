package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CadastroPage;

public class CadastroSemSucessoTest extends BaseTest {

    @DisplayName("Realizando um cadastro sem sucesso com erro de senha")
    @Test
    public void RegistrarNovoUsuarioComDadosErrados() {

    //DADO QUE EU REALIZE UM CADASTRO NO SITE
        CadastroPage cadastroPage = new CadastroPage(driver);
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

    //E INSIRA OS DADOS
        cadastroPage.fillForm("maria.clara@emailfake.com", "Maria", "Clara", "1A");

    //QUANDO ELES NÃO SÃO VALIDOS
        cadastroPage.submitForm();
    //ENTÃO OCORRERÁ UMA MENSAGEM DE ERRO
        String mensagem = cadastroPage.getErrorMessage();
        Assertions.assertEquals("There is 1 error\npasswd is invalid.", mensagem);
    }
}
