package com.nju.dao;

import com.nju.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by thpffcj on 2020/4/5.
 */
public interface ProvinceDao extends JpaRepository<Province, Long> {

    Province findProvinceById(Long id);

    List<Province> findAllByProvinceName(String name);

    List<Province> findAll();
}
