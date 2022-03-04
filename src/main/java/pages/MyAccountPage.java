package pages;

import maps.MyAccountMaps;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    MyAccountMaps myAccountMaps = new MyAccountMaps(driver);

    public void preencherCampoEmail(String valor) throws Exception {
        //fillsField(myAccountMaps.inputEmail(),valor);
        myAccountMaps.inputEmail().sendKeys(valor);
    }

    public void preencherCampoSenha(String valor) throws Exception {
        //fillsField(myAccountMaps.inputSenha(),valor);
        myAccountMaps.inputSenha().sendKeys(valor);
        implicitWait(4000);
        myAccountMaps.inputSenha().sendKeys(Keys.ENTER);
    }

    public void clicarRegister() throws Exception {
        myAccountMaps.botaoRegister().click();
    }

    public void validaBemVindo(String valor) throws InterruptedException {
        implicitlyWait(myAccountMaps.bemVindo(valor));
        Assert.assertEquals(valor,myAccountMaps.bemVindo(valor).getText());
    }
}
