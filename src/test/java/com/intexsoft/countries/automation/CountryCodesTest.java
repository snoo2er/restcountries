package com.intexsoft.countries.automation;

import com.intexsoft.countries.automation.rest.model.Country;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;

public class CountryCodesTest extends BaseTest {

    private static final String TEST_COUNTRY_CODE = "RUS";

    private final SoftAssertions softly = new SoftAssertions();

    @Test
    public void checkCountryCodes() {
        List<String> russiaBorders = codesService.getCountriesByCodes(List.of(TEST_COUNTRY_CODE)).get(0).getBorders();
        russiaBorders.forEach(countryCode -> {
            Country country = codesService.getCountriesByCodes(List.of(countryCode)).get(0);
            softly.assertThat(country.getBorders().contains(TEST_COUNTRY_CODE))
                .withFailMessage("[%s] does not share border with [%s]", country.getName(), TEST_COUNTRY_CODE)
                .isTrue();
        });
        softly.assertAll();
    }

}
