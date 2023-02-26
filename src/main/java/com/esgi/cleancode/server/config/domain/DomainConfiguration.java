package com.esgi.cleancode.server.config.domain;

import com.esgi.cleancode.domain.functional.service.*;
import com.esgi.cleancode.domain.ports.client.*;
import com.esgi.cleancode.domain.ports.server.*;
import com.esgi.cleancode.server.mysql.adapter.*;
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
  public PackDbPort packDbPort() { return new PackAdapter(); }

  @Bean
  public FightDbPort fightDbPort() { return new FightAdapter(); }


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

  @Bean
  public PackCreatorPort packCreatorService(PackDbPort packDbPort) {
    return new PackCreatorService(packDbPort);
  }


  @Bean
  public PackGetAllPort packGetAllService(PackDbPort packDbPort) {
    return new PackGetAllService(packDbPort);
  }

  @Bean
  public FightGetAllPort fightGetAllService(FightDbPort fightDbPort) {
    return new FightGetAllService(fightDbPort);
  }

  @Bean
  public FightCreatorPort fightCreatorService(FightDbPort fightDbPort) {
    return new FightCreatorService(fightDbPort);
  }

  @Bean
  public FightStartPort fightStartService(FightDbPort fightDbPort) {
    return new FightStartService(fightDbPort, heroDbPort(), heroTemplateDbPort());
  }

  @Bean
  public PackOpenPort packOpenService(PackDbPort packDbPort, HeroTemplateDbPort heroTemplateDbPort, HeroCreatorPort heroCreatorPort, PlayerDbPort playerDbPort) {
    return new PackOpenService(packDbPort, heroTemplateDbPort, heroCreatorPort, playerDbPort);
  }

  @Bean
  public HeroGetPlayerHeroPort heroGetPlayerHeroPort(HeroDbPort heroDbPort) {
    return new HeroGetPlayerHeroService(heroDbPort);
  }

}
