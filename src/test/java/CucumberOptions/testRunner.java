package CucumberOptions;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
        
        features = "src/test/java/features",
        glue = "StepDefinitions"
        )

public class testRunner extends AbstractTestNGCucumberTests {

	
}
