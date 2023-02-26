package com.esgi.cleancode.client.controller;

import com.esgi.cleancode.client.dto.HeroDto;
import com.esgi.cleancode.client.mapper.FightDtoMapper;
import com.esgi.cleancode.client.mapper.HeroDtoMapper;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.client.HeroGetAllPort;
import com.esgi.cleancode.domain.ports.client.HeroGetHeroFightsPort;
import com.esgi.cleancode.domain.ports.client.HeroGetPlayerHeroPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hero")
public class HeroController {
    private final HeroCreatorPort heroCreatorPort;
    private final HeroGetAllPort heroGetAllPort;

    private final HeroGetPlayerHeroPort heroGetPlayerHeroPort;

    private final HeroGetHeroFightsPort heroGetHeroFightsPort;

    public HeroController(HeroCreatorPort heroCreatorPort, HeroGetAllPort heroGetAllPort, HeroGetPlayerHeroPort heroGetPlayerHeroPort, HeroGetHeroFightsPort heroGetHeroFightsPort) {

        this.heroCreatorPort = heroCreatorPort;
        this.heroGetAllPort = heroGetAllPort;
        this.heroGetPlayerHeroPort = heroGetPlayerHeroPort;
        this.heroGetHeroFightsPort = heroGetHeroFightsPort;
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createHero(@RequestBody HeroDto heroDto) {
        return heroCreatorPort
                        .create(HeroDtoMapper.HeroCreationToDomain(heroDto))
                        .map(HeroDtoMapper::toDto)
                        .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping
    public ResponseEntity<Object> getAllHero() {
        return heroGetAllPort
                .getAll()
                .map(HeroDtoMapper::toDtoList)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping(path = "/player/{playerId}")
    public ResponseEntity<Object> getAllHero(@PathVariable Integer playerId) {
        return heroGetPlayerHeroPort.getPlayerHero(playerId)
                .map(HeroDtoMapper::toDtoList)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping(path = "/{heroId}/fights")
    public ResponseEntity<Object> getHeroFights(@PathVariable Integer heroId) {
        return heroGetHeroFightsPort.getHeroFights(heroId)
                .map(FightDtoMapper::toDtoList)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
