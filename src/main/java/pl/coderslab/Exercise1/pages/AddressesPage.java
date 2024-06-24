package pl.coderslab.Exercise1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {


    @FindBy(css = "#content > div.addresses-footer > a > span")
    private WebElement createAddressLink;
    private WebDriver driver;


    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateAddressLink() {
        createAddressLink.click();
    }
    public String getFirstAddress() {
                try {
            WebElement firstAddress = driver.findElement(By.cssSelector("#content > div:nth-last-of-type(3) > article > div.address-body > address"));
            return firstAddress.getText();
        } catch (NoSuchElementException ex) {
            return null;
        }
    }
}

