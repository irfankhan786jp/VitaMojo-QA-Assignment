package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.WebDriverUtils;

public class Hooks {

    @Before
    public void initiateDriver(Scenario scenario){
        System.out.println("executes before test");
        if(scenario.getName().contains("UI")){
            WebDriverUtils.getDriver();
        }
    }

    @After
    public void closeDriver(Scenario scenario){
        if(scenario.getName().contains("UI")) {
            WebDriverUtils.setDriver().quit();
        }
    }
}
