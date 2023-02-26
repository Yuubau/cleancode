package com.esgi.cleancode.client.controller;

import com.esgi.cleancode.client.dto.PackDto;
import com.esgi.cleancode.client.mapper.HeroDtoMapper;
import com.esgi.cleancode.client.mapper.HeroTemplateDtoMapper;
import com.esgi.cleancode.client.mapper.PackDtoMapper;
import com.esgi.cleancode.domain.ports.client.PackCreatorPort;
import com.esgi.cleancode.domain.ports.client.PackGetAllPort;
import com.esgi.cleancode.domain.ports.client.PackOpenPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pack")
public class PackController {
    private final PackCreatorPort packCreatorPort;
    private final PackGetAllPort packGetAllPort;
    private final PackOpenPort packOpenPort;



    public PackController(PackCreatorPort packCreatorPort, PackGetAllPort packGetAllPort, PackOpenPort packOpenPort) {
        this.packCreatorPort = packCreatorPort;
        this.packGetAllPort = packGetAllPort;
        this.packOpenPort = packOpenPort;
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createPack(@RequestBody PackDto packDto) {
        return packCreatorPort
                        .create(PackDtoMapper.PackCreationToDomain(packDto))
                        .map(PackDtoMapper::toDto)
                        .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping
    public ResponseEntity<Object> getAllPack() {
        return  packGetAllPort
                .getAll()
                .map(PackDtoMapper::toDtoList)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @PostMapping(path = "/open/player/{playerId}/{packId}")
    public ResponseEntity<Object> openPack(@PathVariable Integer playerId, @PathVariable Integer packId) {
        return  packOpenPort
                .openPack(playerId, packId)
                .map(HeroTemplateDtoMapper::toDtoList)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
