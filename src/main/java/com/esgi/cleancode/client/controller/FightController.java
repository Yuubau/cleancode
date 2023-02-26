package com.esgi.cleancode.client.controller;

import com.esgi.cleancode.client.dto.FightDto;
import com.esgi.cleancode.client.mapper.FightDtoMapper;
import com.esgi.cleancode.domain.ports.client.FightCreatorPort;
import com.esgi.cleancode.domain.ports.client.FightGetAllPort;
import com.esgi.cleancode.domain.ports.client.FightStartPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/fight")
public class FightController {
    private final FightCreatorPort fightCreatorPort;
    private final FightGetAllPort fightGetAllPort;
    private final FightStartPort fightStartPort;


    public FightController(FightCreatorPort fightCreatorPort, FightGetAllPort fightGetAllPort, FightStartPort fightStartPort) {

        this.fightCreatorPort = fightCreatorPort;
        this.fightGetAllPort = fightGetAllPort;
        this.fightStartPort = fightStartPort;
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

    @PostMapping(path = "/{attackingId}/{defendingId}")
    public ResponseEntity<Object> fightStart(@PathVariable Integer attackingId, @PathVariable Integer defendingId) {
        return fightStartPort
                .fight(attackingId, defendingId)
                .map(FightDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
