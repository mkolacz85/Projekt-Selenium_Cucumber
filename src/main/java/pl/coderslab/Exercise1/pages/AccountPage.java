package pl.coderslab.Exercise1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage {
    @FindBy(xpath = "//*[@id=\"addresses-link\"]/span")
    private WebElement addressLink;
    public AccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
public void clickAddressLink(){
        addressLink.click();
    }
}


