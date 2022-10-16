package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.ProductsSauceDemoPage;

public class CartStep extends BaseStep {
    ProductsSauceDemoPage productsSauceDemoPage;
    CartPage cartPage;
    public CartStep(WebDriver driver) {
        super(driver);
        cartPage = new CartPage(driver);
        productsSauceDemoPage = new ProductsSauceDemoPage(driver);
    }
    public void addToCart(){
    }
}
