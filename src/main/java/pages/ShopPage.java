package pages;

import maps.ShopMaps;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ShopPage extends BasePage{
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    ShopMaps shopMaps = new ShopMaps(driver);

    public void clicarItemHTML() throws Exception {
        implicitlyWait(shopMaps.produtoThinkingHTML());
        shopMaps.botaoHTML().click();
    }

    public void validarProdutoThinkingHTML(String nome) throws Exception {
        implicitlyWait(shopMaps.produtoThinkingHTML());
        Assert.assertEquals(shopMaps.produtoThinkingHTML().getText(),nome);
    }
}
