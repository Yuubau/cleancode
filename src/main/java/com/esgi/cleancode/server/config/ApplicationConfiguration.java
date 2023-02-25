package com.esgi.cleancode.server.config;

import io.vavr.jackson.datatype.VavrModule;
import com.esgi.cleancode.server.config.domain.DomainConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DomainConfiguration.class})
public class ApplicationConfiguration {

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper().registerModule(new VavrModule());
  }
}
