package com.esgi.cleancode.client.controller;

import com.esgi.cleancode.client.dto.HeroTemplateDto;
import com.esgi.cleancode.client.mapper.HeroTemplateDtoMapper;
import com.esgi.cleancode.domain.ports.client.HeroTemplateCreatorPort;
import com.esgi.cleancode.domain.ports.client.HeroTemplateGetAllPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hero/template")
public class HeroTemplateController {
    private final HeroTemplateCreatorPort heroTemplateCreatorPort;
    private final HeroTemplateGetAllPort heroTemplateGetAllPort;


    public HeroTemplateController(HeroTemplateCreatorPort heroTemplateCreatorApi, HeroDbPort heroDbSpi, HeroTemplateGetAllPort heroTemplateGetAllPort) {
        this.heroTemplateCreatorPort = heroTemplateCreatorApi;
        this.heroTemplateGetAllPort = heroTemplateGetAllPort;
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createHero(@RequestBody HeroTemplateDto heroTemplateDto) {
        return heroTemplateCreatorPort
                        .create(HeroTemplateDtoMapper.HeroTemplateCreationToDomain(heroTemplateDto))
                        .map(HeroTemplateDtoMapper::toDto)
                        .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping
    public ResponseEntity<Object> getAllHeroTemplates() {
        return heroTemplateGetAllPort
                .getAll()
                .map(HeroTemplateDtoMapper::toDtoList)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
