package com.ramitax.service;

import com.ramitax.configuration.APIConfig;
import com.ramitax.model.response.CountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
@RequiredArgsConstructor
public class GeoLocationService {

    private final APIConfig apiConfig;
    private final WebClient webClient;

    public Flux<CountryResponse> getCountries() {
        return webClient.method(HttpMethod.GET)
                .uri(apiConfig.apiCountryStateCityURL + "/countries")
                .header("X-CSCAPI-KEY", apiConfig.apiCountryStateCityKey)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CountryResponse.class);
    }

}
