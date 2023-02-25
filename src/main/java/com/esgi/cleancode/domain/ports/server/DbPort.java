package com.esgi.cleancode.domain.ports.server;

import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;
import io.vavr.control.Option;


public interface DbPort<T> {
    Either<ApplicationError, T> save(T o);

}
