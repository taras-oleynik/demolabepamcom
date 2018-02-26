package com.epam.tests;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.epam.tests",
        plugin = {"pretty", "html:target/cucumber-html-report"},
        tags = {}
)
public class RunPage {
}
