package com.qaproject.qa2022buscadordecontenido;

import com.qaproject.qa2022buscadordecontenido.models.MovieResults;
import com.qaproject.qa2022buscadordecontenido.models.TvShowResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import static com.qaproject.qa2022buscadordecontenido.utils.Constants.*;

@SpringBootApplication
public class BuscadorContenidoApplication {

    private static final Logger log = LoggerFactory.getLogger(BuscadorContenidoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BuscadorContenidoApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            TvShowResults results = restTemplate.getForObject(TRENDING_TV_URL + TRENDING_DAY + API_KEY_URL, TvShowResults.class);
            assert results != null;
            log.info(results.toString());
        };
    }
}
