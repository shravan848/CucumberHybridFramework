package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/features",
		glue={"stepDefinitions","hooks"},
		monochrome=true,
		plugin= {"rerun:target/failedrerun.txt"}
//		,tags= "@login"
//		,dryRun=true
		)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}