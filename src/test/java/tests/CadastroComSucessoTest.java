package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CadastroPage;

public class CadastroComSucessoTest extends BaseTest {


//DADO QUE EU REALIZE UM CADASTRO NO SITE
    @DisplayName("Dado que eu realize um cadastro com sucesso")
    @Test
    public void RegistrarNovoUsuarioComDadosValidos() {
        CadastroPage cadastroPage = new CadastroPage(driver);
        cadastroPage.openPage();
// QUANDO EU INSIRO OS DADOS CORRETAMENTE
        cadastroPage.fillForm("pedro.augusto@emailfake.com", "Pedro", "Augusto", "123456");
        cadastroPage.submitForm();
//ENTÃO O CADASTRO É REALIZADO COM SUCESSO
        Assertions.assertEquals("Your account has been created.", cadastroPage.getSuccessMessage());
    }
}
