package com.UseRegistryAPI.repository;

import com.UseRegistryAPI.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

public class UserInfoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public UserInfoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User create(User user){
        this.entityManager.persist(user);
        return user;
    }


    public List<User> findAll(){
        return this.entityManager.createQuery(
                "FROM User" , User.class
        ).getResultList();
    }

    public Optional<User> findByUsername(String username){
        return Optional.ofNullable( this.entityManager
                .createQuery("SELECT u FROM User u WHERE u.username = :username" , User.class)
                .setParameter("username",username)
                .getSingleResultOrNull());
//        return this.entityManager
//                .createQuery("SELECT u FROM User u WHERE u.username = :username" , User.class)
//                .setParameter("username",username)
//                .getResultStream().findFirst();
    }
}
