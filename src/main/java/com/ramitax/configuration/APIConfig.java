package com.ramitax.configuration;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class APIConfig {

    @Value("${API_GEOLOCATION_URL}")
    public String apiCountryStateCityURL;

    @Value("${API_GEOLOCATION_KEY}")
    public String apiCountryStateCityKey;

    @Bean
    public WebClient webClient() throws SSLException {
        int bufferSize = 1048576;

        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs()
                        .maxInMemorySize(bufferSize)) // Set buffer size to 1 MB
                .build();

        // Disable ssl verification
        SslContext context = SslContextBuilder.forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        HttpClient httpClient = HttpClient.create()
                .secure(t -> t.sslContext(context))
                .responseTimeout(Duration.ofSeconds(30))
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30 * 1000)
                .doOnConnected(conn -> conn
                        .addHandlerLast(new ReadTimeoutHandler(30,
                                TimeUnit.SECONDS))
                        .addHandlerLast(new WriteTimeoutHandler(30)));

        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

        return WebClient
                .builder()
                .exchangeStrategies(exchangeStrategies)
                .clientConnector(connector)
                .build();

    }
}
