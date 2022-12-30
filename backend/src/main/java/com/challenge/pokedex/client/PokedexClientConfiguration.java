package com.challenge.pokedex.client;

import com.challenge.pokedex.PokedexConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PokedexClientConfiguration {

    public static final String POKEDEX_CLIENT_BEAN = "pokedexClientBean";

    @Bean(POKEDEX_CLIENT_BEAN)
    public WebClient pokedexWebClient(PokedexConfigurationProperties configuration) {

        ExchangeStrategies strategies = ExchangeStrategies
                .builder()
                .codecs(clientDefaultCodecsConfigurer -> {
                    clientDefaultCodecsConfigurer.defaultCodecs().jackson2JsonEncoder(PokedexClientUtils.encoder());
                    clientDefaultCodecsConfigurer.defaultCodecs().jackson2JsonDecoder(PokedexClientUtils.decoder());
                }).build();

        return WebClient.builder()
                .baseUrl(configuration.getBaseUri())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeStrategies(strategies)
                .build();
    }

}
