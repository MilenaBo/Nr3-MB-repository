package com.crud.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoreConfiguration {

    @Bean
    public RestTemplate restTemplate()  {  return new RestTemplate();}
}
//22.2 s9 RestTemplate klasa dostarczana przez Springa,
// umożliwia realizowanie żądań HTTP pomiędzy serwerami.
// Dzięki niej możemy wykonywać żądania takie jak GET, POST, PUT, HEAD
// i natychmiast przetwarzać odpowiedź serwera na obiekt w Javie.