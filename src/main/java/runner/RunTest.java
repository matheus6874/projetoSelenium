package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features",
        glue = "steps",
        plugin = {"html:target/cucumber-reports.html"},
        monochrome = true,
        dryRun = false,
        publish = true
)
public class RunTest {

}