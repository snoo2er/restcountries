package com.intexsoft.countries.automation.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Country {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("borders")
    @Expose
    private List<String> borders;

}
