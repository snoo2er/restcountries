package com.intexsoft.countries.automation.rest.service;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

import com.intexsoft.countries.automation.rest.Endpoints;
import com.intexsoft.countries.automation.rest.SpecificationHandler;
import com.intexsoft.countries.automation.rest.model.Country;
import io.qameta.allure.Step;
import io.restassured.common.mapper.TypeRef;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CodesService {

    private static final String COUNTRY_CODE_PARAM = "codes";

    @Step
    public List<Country> getCountriesByCodes(List<String> codes) {
        log.info("Getting countries by codes '{}'", codes);
        List<Country> countries = given()
            .spec(SpecificationHandler.getRequestSpecification())
            .param(COUNTRY_CODE_PARAM, String.join(",", codes))
            .get(Endpoints.CODES)
            .then()
            .spec(SpecificationHandler.getResponseSpecification())
            .statusCode(SC_OK)
            .extract().body().as(new TypeRef<>() {
            });
        log.info("Countries received '{}'", countries);
        return countries;
    }

}
