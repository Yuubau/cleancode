package com.esgi.cleancode.client.controller;

import com.esgi.cleancode.client.dto.HeroDto;
import com.esgi.cleancode.client.mapper.HeroDtoMapper;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.client.HeroGetAllPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hero")
public class HeroController {
    private final HeroCreatorPort heroCreatorPort;
    private final HeroGetAllPort heroGetAllPort;

    public HeroController(HeroCreatorPort heroCreatorPort, HeroGetAllPort heroGetAllPort) {

        this.heroCreatorPort = heroCreatorPort;
        this.heroGetAllPort = heroGetAllPort;
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
}
