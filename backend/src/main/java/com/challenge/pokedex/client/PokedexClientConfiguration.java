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
    public static final int MAX_MEMORY_SIZE;

    static {
        MAX_MEMORY_SIZE = 16 * 1024 * 1024;
    }

    @Bean(POKEDEX_CLIENT_BEAN)
    public WebClient pokedexWebClient(PokedexConfigurationProperties configuration) {

        ExchangeStrategies strategies = ExchangeStrategies
                .builder()
                .codecs(clientDefaultCodecsConfigurer -> {
                    clientDefaultCodecsConfigurer.defaultCodecs().maxInMemorySize(MAX_MEMORY_SIZE);
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
