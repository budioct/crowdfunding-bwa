package com.bwa.crowdfunding.repository;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

public interface CrudRepository<T, PK> extends ReadRepository<T, PK> {

    T save(T value) throws HibernateException;

    T update(T value) throws HibernateException;

    boolean removeById(PK value) throws HibernateException; // return value di ganti String

}
