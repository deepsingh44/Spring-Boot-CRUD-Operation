package com.deepsingh44.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepsingh44.demo.model.Post;

@Repository
public interface PostDao extends JpaRepository<Post, Integer> {

}
