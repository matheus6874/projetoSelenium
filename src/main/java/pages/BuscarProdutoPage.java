package pages;

import maps.HomeMaps;
import maps.ListaDePesquisaMaps;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BuscarProdutoPage extends BasePage{
    public BuscarProdutoPage(WebDriver driver) {
        super(driver);
    }

    HomeMaps homeMaps = new HomeMaps(driver);
    ListaDePesquisaMaps listaDePesquisaMaps = new ListaDePesquisaMaps(driver);

    public void acessarPaginaHome() throws Exception {
        navigateTo("http://practice.automationtesting.in/");
    }

    public void acessarPaginaShop() throws Exception {
        homeMaps.botaoShop().click();
    }

    public void acessarPaginaMyAccount() throws Exception {
        homeMaps.botaoMyAccount().click();
    }

    public void pesquisarItem(String valor) throws Exception {
        fillsField(homeMaps.inputPesquisa(),valor);
    }

    public void buscaritem() throws Exception {
        homeMaps.inputPesquisa().sendKeys(Keys.ENTER);
    }

    public void validaRetornoBusca(String nome) throws Exception {
        implicitlyWait(listaDePesquisaMaps.produtoThinkingInHtml());
        Assert.assertEquals(listaDePesquisaMaps.produtoThinkingInHtml().getText(),nome);
    }

    public void validaRetornoBuscaProdutoNaoExiste(String nome) throws Exception {
        implicitlyWait(listaDePesquisaMaps.produtoNaoExiste());
        Assert.assertEquals(listaDePesquisaMaps.produtoNaoExiste().getText(),nome);
    }
}
