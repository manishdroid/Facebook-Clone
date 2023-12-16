package com.joe.facebookClone.dao;

import com.joe.facebookClone.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO extends JpaRepository<Post,Integer> {
}
