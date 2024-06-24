package pl.coderslab.Exercise1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

@FindBy(id= "field-email")
    private WebElement emailInput;
@FindBy(id = "field-password")
    private WebElement passwordInput;
@FindBy(css = "#submit-login")
    private WebElement signInButton;
public Loginpage(WebDriver driver){
    PageFactory.initElements(driver, this);
}

    public void setEmailInput(String email){
    emailInput.clear();
    emailInput.sendKeys(email);
    }

    public void setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void clickSignInButton(){
    signInButton.click();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
