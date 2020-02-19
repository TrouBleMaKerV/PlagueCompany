package com.nju.Dao;

import com.nju.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleDao extends JpaRepository<User,Integer> {
}
