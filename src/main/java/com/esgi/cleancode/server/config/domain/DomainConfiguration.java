package com.esgi.cleancode.server.config.domain;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.service.HeroCreatorService;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.server.DbPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.server.mysql.adapter.HeroAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {


  @Bean
  public HeroDbPort heroDbPort() {
    return new HeroAdapter();
  }

  @Bean
  public HeroCreatorPort drivingLicenceCreatorService(HeroDbPort heroDbPort) {
    return new HeroCreatorService(heroDbPort);
  }

}
