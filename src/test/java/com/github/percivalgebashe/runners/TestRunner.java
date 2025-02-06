package com.github.percivalgebashe.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources",
        tags = "@SmokeTest",
        glue = {"com/github/percivalgebashe/stepDefinitions","com/github/percivalgebashe/hooks"},
        plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
