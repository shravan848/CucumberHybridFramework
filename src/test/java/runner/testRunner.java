package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue={"stepDefinitions"},
		monochrome=true,
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumberHtmlReport.html"
				,"rerun:target/failedrerun.txt"}
//		,tags="@excel"
//		,dryRun=true
		,stepNotifications=true
		)
public class testRunner {


}
