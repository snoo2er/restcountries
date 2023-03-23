package com.intexsoft.countries.automation.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationHandler {

    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    public static RequestSpecification getRequestSpecification() {
        if (requestSpecification == null) {
            requestSpecification = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        }
        return requestSpecification;
    }

    public static ResponseSpecification getResponseSpecification() {
        if (responseSpecification == null) {
            responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
        }
        return responseSpecification;
    }

}
