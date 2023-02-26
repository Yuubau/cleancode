package com.esgi.cleancode.client.controller;

import com.esgi.cleancode.client.dto.PlayerDto;
import com.esgi.cleancode.client.mapper.HeroTemplateDtoMapper;
import com.esgi.cleancode.client.mapper.PlayerDtoMapper;
import com.esgi.cleancode.domain.ports.client.PlayerCreatorPort;
import com.esgi.cleancode.domain.ports.client.PlayerGetAllPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/player")
public class PlayerController {
    private final PlayerCreatorPort playerCreatorPort;
    private final PlayerGetAllPort playerGetAllPort;

    public PlayerController(PlayerCreatorPort playerCreatorPort, PlayerGetAllPort playerGetAllPort) {
        this.playerCreatorPort = playerCreatorPort;
        this.playerGetAllPort = playerGetAllPort;
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createPlayer(@RequestBody PlayerDto playerDto) {
        return playerCreatorPort
                        .create(PlayerDtoMapper.PlayerCreationToDomain(playerDto))
                        .map(PlayerDtoMapper::toDto)
                        .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping
    public ResponseEntity<Object> getAllHeroPlayers() {
        return playerGetAllPort
                .getAll()
                .map(PlayerDtoMapper::toDtoList)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
