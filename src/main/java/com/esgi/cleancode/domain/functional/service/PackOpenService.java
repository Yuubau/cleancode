package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.functional.model.Pack;
import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.client.PackOpenPort;
import com.esgi.cleancode.domain.ports.client.PlayerGetByIdPort;
import com.esgi.cleancode.domain.ports.server.HeroTemplateDbPort;
import com.esgi.cleancode.domain.ports.server.PackDbPort;
import com.esgi.cleancode.domain.ports.server.PlayerDbPort;
import io.vavr.control.Either;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PackOpenService implements PackOpenPort {

    private final PackDbPort spi;
    private final HeroTemplateDbPort heroTemplateDbPort;

    private final HeroCreatorPort heroCreatorPort;
    private final PlayerDbPort playerDdPort;


    public PackOpenService(PackDbPort spi, HeroTemplateDbPort heroTamplateDbPort, HeroCreatorPort heroCreatorPort, PlayerDbPort playerDdPort) {
        this.spi = spi;
        this.heroTemplateDbPort = heroTamplateDbPort;
        this.heroCreatorPort = heroCreatorPort;
        this.playerDdPort = playerDdPort;
    }

    @Override
    public Either<ApplicationError, List<HeroTemplate>> openPack(Integer playerId, Integer packId) {
        Pack pack = spi.getById(packId).get();
        Player player = playerDdPort.getById(playerId).get();
        if(player.getChipNumber() < pack.getPrice()) {
            return Either.left(new ApplicationError("Error", "An error occured", null, null));
        }
        player.setChipNumber(player.getChipNumber() - pack.getPrice());
        playerDdPort.update(player);
        List<HeroTemplate> list = heroTemplateDbPort.getAll().get();
        List<HeroTemplate> res = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < pack.getCardNumber(); i++) {
            HeroTemplate template = null;
            Integer result = Math.toIntExact(Math.round(Math.random() * 100));
            if(result <= pack.getCommonPercentage()){ // COMMON
                result = 0;
            } else if (result <= pack.getCommonPercentage() + pack.getRarePercentage()){ // RARE
                result = 1;
            } else { // LEGENDARY
                result = 2;
            }
            for (HeroTemplate heroTemplate : list) {
                if (Objects.equals(heroTemplate.getRarity(), result)) {
                    template = heroTemplate;
                    break;
                }
            }
            res.add(template);
            heroCreatorPort.create(Hero.builder()
                    .heroId(template.getId())
                    .playerId(playerId)
                    .experiencePoints(0)
                    .level(1).build()
            ).get();
        }
        return Either.right(res);
    }
}