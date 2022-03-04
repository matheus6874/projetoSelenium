package maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class HomeMaps extends BasePage {
    public HomeMaps(WebDriver driver) {
        super(driver);
    }

    public WebElement inputPesquisa() {
        WebElement element = driver.findElement(By.xpath("//input[@id='s']"));
        return element;
    }

    public WebElement botaoShop() {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Shop')]"));
        return element;
    }

    public WebElement botaoMyAccount() {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
        return element;
    }

    //a[contains(text(),'Thinking in HTML')]



}
