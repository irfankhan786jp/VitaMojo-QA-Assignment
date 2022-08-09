package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[text()='Create Account']")
    private WebElement createAccountTab;

    @FindBy(how = How.ID, using = "firstName")
    private WebElement nameTextBox;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailTextBox;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordTextBox;

    @FindBy(how = How.XPATH, using = "//*[@class ='css-q1j3qv e379e0i4']")
    private WebElement checkbox;

    @FindBy(how = How.XPATH, using = "//*[@class ='css-rxq2le e2l7ybf8']")
    private WebElement createAccountButton;


    public void clickCreateAccountTab(){
        createAccountTab.click();
    }
    public void inputNameTextBox(String value){
        nameTextBox.sendKeys(value);
    }
    public void inputEmailTextBox(String value){
        emailTextBox.sendKeys(value);
    }
    public void inputPasswordTextBox(String value){
        passwordTextBox.sendKeys(value);
    }
    public void clickCheckbox(){
        checkbox.click();
    }
    public void clickCreateAccountButton(){
        createAccountButton.click();
    }

}
