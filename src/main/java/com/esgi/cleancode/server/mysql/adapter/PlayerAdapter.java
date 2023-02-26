package com.esgi.cleancode.server.mysql.adapter;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.domain.ports.server.PlayerDbPort;
import com.esgi.cleancode.server.mysql.dao.HeroDao;
import com.esgi.cleancode.server.mysql.dao.PlayerDao;
import com.esgi.cleancode.server.mysql.entity.HeroEntity;
import com.esgi.cleancode.server.mysql.entity.PlayerEntity;
import com.esgi.cleancode.server.mysql.mapper.PlayerEntityMapper;
import io.vavr.control.Either;

import java.util.List;

import static com.esgi.cleancode.server.mysql.mapper.PlayerEntityMapper.fromDomain;
import static io.vavr.API.Try;

public class PlayerAdapter extends PlayerDao implements PlayerDbPort {


    @Override
    public Either<ApplicationError, Player> save(Player o) {
        PlayerEntity entity = fromDomain(o);
        return Try(() -> super.insert(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, o, throwable))
                .map(PlayerEntityMapper::toDomain);
    }

    @Override
    public Either<ApplicationError, List<Player>> getAll() {
        return Try(() -> super.getList("SELECT * FROM player;", PlayerEntity.class))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, null, throwable))
                .map(PlayerEntityMapper::toDomainList);
    }

}
