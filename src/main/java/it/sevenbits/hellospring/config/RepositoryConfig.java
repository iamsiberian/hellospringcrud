package it.sevenbits.hellospring.config;

import it.sevenbits.hellospring.core.repository.ItemsRepository;
import it.sevenbits.hellospring.core.repository.SampleItemsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean
    public ItemsRepository itemsRepository() {
        return new SampleItemsRepository();
    }

}
