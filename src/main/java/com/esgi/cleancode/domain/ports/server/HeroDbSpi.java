package com.esgi.cleancode.domain.ports.server;

import com.esgi.cleancode.domain.functional.model.Hero;

import java.util.UUID;

public interface HeroDbSpi extends DbSpi<Hero, UUID> {}
