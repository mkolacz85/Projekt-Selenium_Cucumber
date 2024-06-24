package pl.coderslab.Exercise1.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.Exercise1.pages.AccountPage;
import pl.coderslab.Exercise1.pages.AddressesPage;
import pl.coderslab.Exercise1.pages.CreateAddressPage;
import pl.coderslab.Exercise1.pages.Loginpage;

import static org.junit.Assert.assertTrue;

public class CreateAddressSteps {
    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("the user is on the my store login page")
    public void theUserIsOnTheMyStoreLoginPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("the user types correct {string} and {string}")
    public void theUserTypesCorrectAnd(String email, String password) {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.setEmailInput(email);
        loginpage.setPasswordInput(password);

    }

    @And("the user click sign button")
    public void theUserClickSignButton() {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.clickSignInButton();
    }

    @And("the user click  address button at account page")
    public void theUserClickAddressButtonAtAccountPage() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickAddressLink();
    }

    @And("the user click create address button at addresses page")
    public void theUserClickCreateAddressButtonAtAddressesPage() {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.clickCreateAddressLink();
    }


    @And("the user fills  {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserFills(String alias, String address, String city, String postalCode, String country, String phone) {
        CreateAddressPage createAddressPage = new CreateAddressPage(driver);
        createAddressPage.typeAlias(alias);
        createAddressPage.typeAddress(address);
        createAddressPage.typeCity(city);
        createAddressPage.typePostalCode(postalCode);
        createAddressPage.selectCountry(country);
        createAddressPage.typePhone(phone);
    }

    @And("the user click save button")
    public void theUserClickSaveButton() {
        CreateAddressPage createAddressPage = new CreateAddressPage(driver);
        createAddressPage.clickSaveButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the new address should be added")
    public void theNewAddressShouldBeAdded() {
        AddressesPage addressesPage = new AddressesPage(driver);
        String firstAddress = addressesPage.getFirstAddress();
        assertTrue(firstAddress.contains("Happy"));
        assertTrue(firstAddress.contains("London"));
        assertTrue(firstAddress.contains("10-100"));
        assertTrue(firstAddress.contains("United Kingdom"));
        assertTrue(firstAddress.contains("123456"));
    }
}


