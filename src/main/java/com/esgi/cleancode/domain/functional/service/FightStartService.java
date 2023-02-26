package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.functional.model.HeroType;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.FightStartPort;
import com.esgi.cleancode.domain.ports.server.FightDbPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.domain.ports.server.HeroTemplateDbPort;
import io.vavr.control.Either;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public class FightStartService implements FightStartPort {

    private final FightDbPort fightDbPort;
    private final HeroDbPort heroDbPort;
    private final HeroTemplateDbPort heroTemplateDbPort;


    public FightStartService(FightDbPort fightDbPort, HeroDbPort heroDbPort, HeroTemplateDbPort heroTemplateDbPort) {
        this.fightDbPort = fightDbPort;
        this.heroDbPort = heroDbPort;
        this.heroTemplateDbPort = heroTemplateDbPort;
    }

    @Override
    public Either<ApplicationError, Fight> fight(Integer attackingHeroId, Integer defendingHeroId) {
        HeroTemplate attackingTemplate = null;
        HeroTemplate defendingTemplate = null;
        Hero attackingHero;
        Hero defendingHero;
        try {
            attackingHero = heroDbPort.getById(attackingHeroId).get();
            defendingHero = heroDbPort.getById(defendingHeroId).get();
            attackingTemplate = heroTemplateDbPort.getById(attackingHero.getHeroId()).get();
            defendingTemplate = heroTemplateDbPort.getById(defendingHero.getHeroId()).get();
            Integer attackingBonusPower = computeBonusPower(attackingTemplate, defendingTemplate);
            Integer defendingBonusPower = computeBonusPower(defendingTemplate, attackingTemplate);
            computeLevel(attackingHero, attackingTemplate);
            computeLevel(defendingHero, defendingTemplate);
            boolean attackingTurn = true;
            while (attackingTemplate.getHealthPoints() > 0 && defendingTemplate.getHealthPoints() > 0) {
                if (attackingTurn) {
                    defendingTemplate.setHealthPoints(defendingTemplate.getHealthPoints()
                            - (attackingTemplate.getPower() + attackingBonusPower - defendingTemplate.getArmor()));
                } else {
                    attackingTemplate.setHealthPoints(attackingTemplate.getHealthPoints()
                            - (defendingTemplate.getPower() + defendingBonusPower - attackingTemplate.getArmor()));
                }
                attackingTurn = !attackingTurn;
            }
        } catch (Exception e) {
            return Either.left(new ApplicationError(
                    "Error", "An error occured", attackingTemplate, e.getCause()));
        }
        Fight f = new Fight();
        f.setAttackerWin(attackingTemplate.getHealthPoints() > 0);
        f.setAttackingHeroId(attackingHeroId);
        f.setDefendingHeroId(defendingHeroId);
        fightDbPort.save(f);

        Hero winner = attackingTemplate.getHealthPoints() > 0 ? attackingHero : defendingHero;
        winner.setExperiencePoints(winner.getExperiencePoints() + 1);
        if(winner.getExperiencePoints() == 5) {
            winner.setLevel(winner.getLevel() + 1);
            winner.setExperiencePoints(0);
        }
        heroDbPort.update(winner);

        return Either.right(f);

    }

    private Integer computeBonusPower(HeroTemplate attackingHero, HeroTemplate defendingHero) {
        System.out.println(attackingHero);
        System.out.println(defendingHero);
        switch (attackingHero.getHeroType()) {
            case 0 -> {
                if (defendingHero.getHeroType() == 2) {
                    return 20;
                }
                return 0;
            }
            case 1 -> {
                if (defendingHero.getHeroType() == 0) {
                    return 30;
                }
                return 0;
            }
            case 2 -> {
                if (defendingHero.getHeroType() == 1) {
                    return 25;
                }
                return 0;
            }
            default -> {
                return 0;
            }
        }
    }

    private HeroTemplate computeLevel(Hero attackingHero, HeroTemplate attackingTemplate) {
        Integer level = attackingHero.getLevel();
        attackingTemplate.setPower(attackingTemplate.getPower() * (((level*10) + 100)/100));
        attackingTemplate.setArmor(attackingTemplate.getArmor() * (((level*10) + 100)/100));
        attackingTemplate.setHealthPoints(attackingTemplate.getHealthPoints() * (((level*10) + 100)/100));
        return attackingTemplate;
    }
}
