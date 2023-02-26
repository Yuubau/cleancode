package com.esgi.cleancode.client.controller;

import com.esgi.cleancode.client.dto.HeroDto;
import com.esgi.cleancode.client.dto.PlayerDto;
import com.esgi.cleancode.client.mapper.HeroDtoMapper;
import com.esgi.cleancode.client.mapper.HeroTemplateDtoMapper;
import com.esgi.cleancode.client.mapper.PlayerDtoMapper;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.client.PlayerCreatorPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/player")
public class PlayerController {
    private final PlayerCreatorPort playerCreatorPort;

    public PlayerController(PlayerCreatorPort playerCreatorPort) {
        this.playerCreatorPort = playerCreatorPort;
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createPlayer(@RequestBody PlayerDto playerDto) {
        return playerCreatorPort
                        .create(PlayerDtoMapper.PlayerCreationToDomain(playerDto))
                        .map(PlayerDtoMapper::toDto)
                        .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping
    public ResponseEntity<Object> getAllHeroTemplates() {
        return playerCreatorPort
                .getAll()
                .map(HeroTemplateDtoMapper::toDtoList)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
