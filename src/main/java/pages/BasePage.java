package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BasePage {
    public WebDriverWait wait;
    public WebDriver driver;
    public Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, 60);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }

    /**
     * Metodo de acesso a url
     *
     * @param url
     */
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    /**
     * Metodo de preenchimento dos inputs
     *
     * @param campo
     * @param value
     */
    public void fillsField(WebElement campo, String value) {
        wait.until(ExpectedConditions.visibilityOf(campo));
        campo.clear();
        campo.sendKeys(value);
    }


    public void clearFieldWithClick(WebElement campo) {
        wait.until(ExpectedConditions.visibilityOf(campo));
        campo.click();
        campo.clear();
    }


    public void clearField(WebElement campo) {
        wait.until(ExpectedConditions.visibilityOf(campo));
        campo.clear();
    }

    /**
     * Metodo para send keys slowly
     * @param element
     * @param value
     */
    public void typeInField(WebElement element, String value){
        String val = value;
        element.clear();

        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
    }


    public static void typingHumanKeys(WebElement element, String value) {
        Random r = new Random();
        for(int i = 0; i < value.length(); i++) {
            try {
                Thread.sleep((int)(r.nextGaussian() * 15 + 100));
            } catch(InterruptedException e) {}
            String s = new StringBuilder().append(value.charAt(i)).toString();
            element.sendKeys(s);
        }
    }


    /**
     * Metodo de click no WebElement
     *
     * @param element
     */
    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Metodo de double click no WebElement
     *
     * @param element
     */
    public void doubleClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        action.doubleClick(element);
    }

    /**
     * Metodo de click no WebElement
     *
     * @param element
     */
    public void clickAndPaste(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.sendKeys(Keys.CONTROL + "v");
    }

    /**
     * Metodo de click no WebElement
     *
     * @param element
     */
    public void clickAndMoveArrow(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.sendKeys(Keys.DOWN);
        element.sendKeys(Keys.ENTER);
    }


    /**
     * Metodo de espera explicita
     *
     * @param tempoEmMilissegundos
     * @throws InterruptedException
     */
    public static void implicitWait(int tempoEmMilissegundos) throws InterruptedException {
        System.out.println("Espera Implicita de " + tempoEmMilissegundos + " Milisegundos");
        Thread.sleep(tempoEmMilissegundos);
    }

    public void implicitlyWait(WebElement element) throws InterruptedException {
        System.out.println("Espera Implicita do elemento: " + element);
        //driver.manage().timeouts().implicitlyWait(tempoEmMilissegundos, TimeUnit.MILLISECONDS);
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public String gerarCpf() {
        RestAssured.baseURI = "https://www.4devs.com.br/ferramentas_online.php";
        String acao = "gerar_cpf";
        String body = String.format("acao=%s", acao);
        Response response = given().with().
                header("Content-Type", "application/x-www-form-urlencoded").
                body(body).
                post(baseURI);

        return response.getBody().asString();
    }

    public void makeScreenshot(String namePicture) throws Exception {
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("target/"+namePicture+".PNG"));
    }
}

