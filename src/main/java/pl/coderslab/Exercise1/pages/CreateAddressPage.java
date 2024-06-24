package pl.coderslab.Exercise1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAddressPage {
    @FindBy(id = "field-alias")
    private WebElement aliasInput;
    @FindBy(id = "field-address1")
    private WebElement addressInput;
    @FindBy(id = "field-city")
    private WebElement cityInput;
    @FindBy(id = "field-postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "field-id_country")
    private WebElement countryDropdown;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;
    @FindBy(css = "#content > div > div > form > footer > button")
    private WebElement saveButton;

    public CreateAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void typeAlias(String alias) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    public void typeAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void typeCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void typePostalCode(String postalCode) {
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }


    public void selectCountry(String country) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }

    public void typePhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void clickSaveButton() {
        saveButton.click();

    }
}

