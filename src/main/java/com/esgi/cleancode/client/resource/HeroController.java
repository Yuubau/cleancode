package com.esgi.cleancode.client.resource;

import com.esgi.cleancode.client.dto.HeroDto;
import com.esgi.cleancode.client.mapper.HeroDtoMapper;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.server.mysql.mapper.HeroEntityMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hero")
public class HeroController {
    private final HeroCreatorPort heroCreatorApi;

    public HeroController(HeroCreatorPort heroCreatorApi, HeroDbPort heroDbSpi) {
        this.heroCreatorApi = heroCreatorApi;
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createHero(@RequestBody HeroDto heroDto) {
        return heroCreatorApi
                        .create(HeroDtoMapper.HeroCreationToDomain(heroDto))
                        .map(HeroDtoMapper::toDto)
                        .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
