package com.cucumber.login;

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Feature"
        , glue = {"com.cucumber.login"}
        , monochrome = false
)

public class TestRunner {

}


