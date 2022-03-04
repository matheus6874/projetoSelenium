package maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ShopMaps extends BasePage {
    public ShopMaps(WebDriver driver) {
        super(driver);
    }

    public WebElement botaoHTML() {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'HTML')]"));
        return element;
    }

    public WebElement produtoThinkingHTML() {
        WebElement element = driver.findElement(By.xpath("//h3[contains(text(),'Thinking in HTML')]"));
        return element;
    }
}
