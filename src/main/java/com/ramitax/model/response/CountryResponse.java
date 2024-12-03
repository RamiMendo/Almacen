package com.ramitax.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("capital")
    private String capital;

}
