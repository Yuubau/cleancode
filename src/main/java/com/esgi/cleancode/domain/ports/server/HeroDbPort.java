package com.esgi.cleancode.domain.ports.server;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.server.mysql.entity.HeroEntity;

public interface HeroDbPort extends DbPort<Hero> {}
