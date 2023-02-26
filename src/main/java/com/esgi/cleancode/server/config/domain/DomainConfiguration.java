package com.esgi.cleancode.server.config.domain;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.service.*;
import com.esgi.cleancode.domain.ports.client.*;
import com.esgi.cleancode.domain.ports.server.DbPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.domain.ports.server.HeroTemplateDbPort;
import com.esgi.cleancode.domain.ports.server.PlayerDbPort;
import com.esgi.cleancode.server.mysql.adapter.HeroAdapter;
import com.esgi.cleancode.server.mysql.adapter.HeroTemplateAdapter;
import com.esgi.cleancode.server.mysql.adapter.PlayerAdapter;
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
  public HeroTemplateDbPort heroTemplateDbPort() {
    return new HeroTemplateAdapter();
  }

  @Bean
  public PlayerDbPort playerDbPort() {
    return new PlayerAdapter();
  }


  @Bean
  public HeroCreatorPort heroCreatorService(HeroDbPort heroDbPort) {
    return new HeroCreatorService(heroDbPort);
  }

  @Bean
  public HeroTemplateCreatorPort heroTemplateCreatorService(HeroTemplateDbPort heroTemplateDbPort) {
    return new HeroTemplateCreatorService(heroTemplateDbPort);
  }

  @Bean
  public PlayerCreatorPort playerCreatorService(PlayerDbPort playerDbPort) {
    return new PlayerCreatorService(playerDbPort);
  }

  @Bean
  public HeroTemplateGetAllPort heroTemplateGetAllService(HeroTemplateDbPort heroTemplateDbPort) {
    return new HeroTemplateGetAllService(heroTemplateDbPort);
  }



  @Bean
  public HeroTemplateGetByIdPort heroTemplateGetByIdService(HeroTemplateDbPort heroTemplateDbPort) {
    return new HeroTemplateGetByIdService(heroTemplateDbPort);
  }



  @Bean
  public PlayerGetAllPort playerGetAllService(PlayerDbPort playerDbPort) {
    return new PlayerGetAllService(playerDbPort);
  }

  @Bean
  public HeroGetAllPort HeroGetAllService(HeroDbPort heroDbPort) {
    return new HeroGetAllService(heroDbPort);
  }

}
