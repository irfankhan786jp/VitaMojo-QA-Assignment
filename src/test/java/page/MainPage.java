package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@class ='css-tb5rmf e1e0uu431']/a")
    private WebElement clickLoginButtonMainPage;

    public void clickLoginButtonMainPage(){
        clickLoginButtonMainPage.click();
    }
}
