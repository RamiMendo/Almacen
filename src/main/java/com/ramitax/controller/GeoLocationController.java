package com.ramitax.controller;

import com.ramitax.model.response.CountryResponse;
import com.ramitax.service.GeoLocationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/geolocation")
public class GeoLocationController {

    @Autowired
    private GeoLocationService geoLocationService;

    @GetMapping(path = "/paises", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"GEOLOCATION"}
    )
    private @ResponseBody Flux<CountryResponse> getPaises(){
        return geoLocationService.getCountries();
    }

}
