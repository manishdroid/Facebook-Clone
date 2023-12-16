package com.joe.facebookClone.dao;

import com.joe.facebookClone.models.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserDAO extends JpaRepository<AppUsers, Integer> {
    AppUsers findByEmail(String email);

    @Query(value = "select name,id From appUsers",nativeQuery = true)
    List<AppUsers> fetchAppUsers();

}