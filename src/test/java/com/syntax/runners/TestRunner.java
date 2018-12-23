package com.syntax.runners;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/features"}
				, glue= {"com/syntax/stepDefinitions"}
				, dryRun=false
			    , monochrome = true
				,tags= {"@Vacancy"})

public class TestRunner {

}
