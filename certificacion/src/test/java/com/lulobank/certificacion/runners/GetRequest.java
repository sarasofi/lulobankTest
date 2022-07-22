package com.lulobank.certificacion.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		glue = { "com.lulobank.certificacion.stepdefinitions"}, 
		features = { "src/test/resources/features/get_employees.feature" }, 
        snippets = SnippetType.CAMELCASE, 
        monochrome = true,
        dryRun = false
)

public class GetRequest {

}
