package com.docker.atsea.test_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


import org.junit.runner.RunWith;

/**
 * Created by sarndeep on 12/12/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(strict=false, features="src/test/resources/features", plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json", "junit:target/cucumnber-TEST-report.xml"},
tags={}, glue={"com.docker.atsea.step_definitions"})
public class RunAllTests {
}
