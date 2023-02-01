package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/features",
		glue={"stepDefinitions","hooks"},
		monochrome=true,
		plugin= {"pretty","rerun:target/failedrerun.txt"
				,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		,tags= "@search"
//		,dryRun=true
		)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}