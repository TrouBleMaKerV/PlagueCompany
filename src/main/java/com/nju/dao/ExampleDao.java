package com.nju.dao;

import com.nju.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleDao extends JpaRepository<User,Integer> {
}
