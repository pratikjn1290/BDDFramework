package com.product.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "src/test/java/com/product/feature" }, glue = { "com/product/stepdefination",
				"appHooks" }, plugin = {
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class MyRunner {

}
