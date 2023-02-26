package com.esgi.cleancode.domain.ports.server;

import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.List;


public interface DbPort<T> {
    Either<ApplicationError, T> save(T o);

    Either<ApplicationError, List<T>> getAll();

    Either<ApplicationError, T> getById(Integer id);

    Either<ApplicationError, T> update(T o);

}
