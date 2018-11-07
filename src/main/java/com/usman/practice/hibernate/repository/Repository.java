package com.usman.practice.hibernate.repository;

import java.util.List;

public interface Repository<T> {
    void add(T t);

    List<T> get();

    boolean delete(String id);

    void update(T employee);
}
