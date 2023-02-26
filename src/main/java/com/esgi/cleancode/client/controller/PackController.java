package com.esgi.cleancode.client.controller;

import com.esgi.cleancode.client.dto.PackDto;
import com.esgi.cleancode.client.mapper.PackDtoMapper;
import com.esgi.cleancode.domain.ports.client.PackCreatorPort;
import com.esgi.cleancode.domain.ports.client.PackGetAllPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pack")
public class PackController {
    private final PackCreatorPort packCreatorPort;
    private final PackGetAllPort packGetAllPort;


    public PackController(PackCreatorPort packCreatorPort, PackGetAllPort packGetAllPort) {
        this.packCreatorPort = packCreatorPort;
        this.packGetAllPort = packGetAllPort;
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
}
