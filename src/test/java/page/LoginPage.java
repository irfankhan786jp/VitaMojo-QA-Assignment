package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "email")
    private WebElement emailTextBox;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordTextBox;

    @FindBy(how = How.XPATH, using = "//*[text()='Login']")
    private WebElement loginPageLoginButton;

    public void inputEmailTextBox(String value){
        emailTextBox.sendKeys(value);
    }
    public void inputPasswordTextBox(String value){
        passwordTextBox.sendKeys(value);
    }
    public void clickLoginPageLoginButton(){
        loginPageLoginButton.click();
    }
}
