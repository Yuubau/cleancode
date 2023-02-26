package com.esgi.cleancode.client.controller;

import com.esgi.cleancode.client.dto.FightDto;
import com.esgi.cleancode.client.mapper.FightDtoMapper;
import com.esgi.cleancode.domain.ports.client.FightCreatorPort;
import com.esgi.cleancode.domain.ports.client.FightGetAllPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/fight")
public class FightController {
    private final FightCreatorPort fightCreatorPort;
    private final FightGetAllPort fightGetAllPort;

    public FightController(FightCreatorPort fightCreatorPort, FightGetAllPort fightGetAllPort) {

        this.fightCreatorPort = fightCreatorPort;
        this.fightGetAllPort = fightGetAllPort;
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createFight(@RequestBody FightDto fightDto) {
        return fightCreatorPort
                        .create(FightDtoMapper.FightCreationToDomain(fightDto))
                        .map(FightDtoMapper::toDto)
                        .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping
    public ResponseEntity<Object> getAllFight() {
        return fightGetAllPort
                .getAll()
                .map(FightDtoMapper::toDtoList)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
