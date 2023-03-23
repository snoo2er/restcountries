package com.intexsoft.countries.automation;

import static io.restassured.RestAssured.filters;

import com.intexsoft.countries.automation.rest.service.CodesService;
import com.intexsoft.countries.automation.util.PropertyReader;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public CodesService codesService = new CodesService();

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        filters(new RequestLoggingFilter(),
                new ResponseLoggingFilter(),
                new AllureRestAssured());

        RestAssured.baseURI = PropertyReader.getInstance().getTestProperty("app.url");
    }

}
