//import io.cucumber.java.After;
//import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.FeatureWrapper;
//import io.cucumber.testng.PickleWrapper;
//import io.cucumber.testng.TestNGCucumberRunner;
//import org.testng.annotations.*;
//import utils.WebDriverUtils;
//
//@CucumberOptions(
//        features = "src/test/resources/Features/",
//        glue = "C:\\Users\\irfan\\Downloads\\Vita Mojo Demo\\src\\test\\java\\stepDefs",
//        tags = "@Registration",
//        plugin = "json:target/cucumber-reports/CucumberTestReport.json")
//
//
//public class Runner {
//
//    private TestNGCucumberRunner testNGCucumberRunner;
//
//    @BeforeClass(alwaysRun = true)
//    public void setUpCucumber() {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//
//    @BeforeMethod(alwaysRun = true)
//    public void setUpClass() throws Exception {
//        System.out.println("Entered Before Method");
//        WebDriverUtils.getDriver();
//    }
//
//    @Test(dataProvider = "scenarios")
//    public void runScenarios(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
//        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
//    }
//
//    @DataProvider
//    public Object[][] scenarios() {
//        return this.testNGCucumberRunner.provideScenarios();
//    }
//
//    @AfterMethod
//    public void closeDriver(){
//        WebDriverUtils.getDriver().quit();
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() throws Exception {
//        testNGCucumberRunner.finish();
//    }
//}
//
