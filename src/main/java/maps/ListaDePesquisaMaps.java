package maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ListaDePesquisaMaps extends BasePage {
    public ListaDePesquisaMaps(WebDriver driver) {
        super(driver);
    }

    public WebElement produtoThinkingInHtml() {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Thinking in HTML')]"));
        return element;
    }

    public WebElement produtoNaoExiste() {
        WebElement element = driver.findElement(By.xpath("//em[contains(text(),'itemNãoExiste')]"));
        return element;
    }
}
