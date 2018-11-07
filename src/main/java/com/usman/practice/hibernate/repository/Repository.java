package com.usman.practice.hibernate.repository;

import com.usman.practice.hibernate.entity.Employee;

import java.util.List;

public interface Repository<T> {
    String add(T t);

    List<T> getList();

    boolean delete(String id);

    void update(T employee);

    T get(String id);

}
