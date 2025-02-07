package TestRun;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions
(
features= {".//Features/flipkart.feature"},
glue= {"StepDef","Hooks"},
tags= "@Sanity",
dryRun=false,
monochrome=true,
plugin= {"pretty","html:target/cucumber-reports.html"}
		
)

public class TestRun {

}
