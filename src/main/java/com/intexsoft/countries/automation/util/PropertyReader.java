package com.intexsoft.countries.automation.util;

import java.util.ResourceBundle;

public class PropertyReader {

    private static PropertyReader instance;
    private static ResourceBundle testResourceBundle;

    private PropertyReader() {
    }

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }

    public String getTestProperty(String key) {
        if (testResourceBundle == null) {
            testResourceBundle = ResourceBundle.getBundle("test");
        }
        return testResourceBundle.getString(key);
    }

}
