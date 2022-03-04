package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.BuscarProdutoPage;
import pages.MyAccountPage;
import pages.ShopPage;
import utils.GeraEmail;

public class PraticeSteps {

    private BuscarProdutoPage buscarProdutoPage;
    private ShopPage shopPage;
    private MyAccountPage myAccountPage;
    private GeraEmail geraEmail;
    private String email;

    public PraticeSteps() {
        buscarProdutoPage = new BuscarProdutoPage(BaseTest.driver);
        shopPage = new ShopPage(BaseTest.driver);
        myAccountPage = new MyAccountPage(BaseTest.driver);
        geraEmail = new GeraEmail();
    }


    @Dado("que acesso a página home do site Automation Practice")
    public void que_acesso_a_página_home_do_site_automation_practice() throws Exception {
        buscarProdutoPage.acessarPaginaHome();
    }

    @Quando("digito o nome do produto {string} no campo de pesquisa")
    public void digito_o_nome_do_produto_no_campo_de_pesquisa(String nome) throws Exception {
        buscarProdutoPage.pesquisarItem(nome);
    }
    @Quando("clico no botão de pesquisa")
    public void clico_no_botão_de_pesquisa() throws Exception {
        buscarProdutoPage.buscaritem();
    }
    @Então("confiro se o produto {string} foi listado no site")
    public void confiro_se_o_produto_foi_listado_no_site(String produto) throws Exception {
        buscarProdutoPage.validaRetornoBusca(produto);
    }

    @Então("confiro mensagem {string}")
    public void confiro_mensagem(String produto) throws Exception {
        buscarProdutoPage.validaRetornoBuscaProdutoNaoExiste(produto);
    }

    @Quando("clique no menu Shop")
    public void clique_no_menu_shop() throws Exception {
        buscarProdutoPage.acessarPaginaShop();
    }
    @Quando("passo o mouse por cima da categoria {string} no menu lateral esquerdo de categorias")
    public void passo_o_mouse_por_cima_da_categoria_no_menu_lateral_esquerdo_de_categorias(String string) throws Exception {
        shopPage.clicarItemHTML();
    }
    @Quando("na sub categoria {string}")
    public void na_sub_categoria(String string) {
        System.out.println("Acesso a opcao" + string);
    }
    @Então("confiro se o produto {string}  esta presente")
    public void confiro_se_o_produto_esta_presente(String produto) throws Exception {
        shopPage.validarProdutoThinkingHTML(produto);
    }

    @Quando("clico em {string}")
    public void clico_em(String string) throws Exception {
        System.out.println("Clicando em " + string);
        buscarProdutoPage.acessarPaginaMyAccount();
    }
    @Quando("faço um novo cadastro no box {string}")
    public void faço_um_novo_cadastro_no_box(String string) {
        System.out.println("Cadastrando novo usuario na pagina " + string);
    }
    @Quando("informo um e-mail válido")
    public void informo_um_e_mail_válido() throws Exception {
        email = geraEmail.geraEmail();
    }
    @Quando("preencher os dados obrigatórios")
    public void preencher_os_dados_obrigatórios() throws Exception {
        myAccountPage.preencherCampoEmail(email);
        myAccountPage.preencherCampoSenha("Teste@Bana12");
    }
    @Quando("submeter cadastro")
    public void submeter_cadastro() throws Exception {
       // myAccountPage.clicarRegister();
    }
    @Então("confiro se o cadastro foi efetuado com sucesso")
    public void confiro_se_o_cadastro_foi_efetuado_com_sucesso() throws InterruptedException {
        String username[] = email.split("@");
        myAccountPage.validaBemVindo(username[0]);
    }
}
