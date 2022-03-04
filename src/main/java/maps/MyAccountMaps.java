package maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class MyAccountMaps extends BasePage {
    public MyAccountMaps(WebDriver driver) {
        super(driver);
    }

    public WebElement inputEmail() {
        WebElement element = driver.findElement(By.xpath("//input[@id='reg_email']"));
        return element;
    }

    public WebElement inputSenha() {
        WebElement element = driver.findElement(By.xpath("//input[@id='reg_password']"));
        return element;
    }

    public WebElement botaoRegister() {
        WebElement element = driver.findElement(By.xpath("//input[@name='register']"));
        return element;
    }

    public WebElement bemVindo(String valor) {
        WebElement element = driver.findElement(By.xpath("//strong[contains(text(),'"+valor+"')]"));
        return element;
    }







}
