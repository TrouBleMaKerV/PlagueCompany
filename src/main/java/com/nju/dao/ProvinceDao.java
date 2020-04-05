package com.nju.dao;

import com.nju.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by thpffcj on 2020/4/5.
 */
public interface ProvinceDao extends JpaRepository<Province, Long> {

    Province findProvinceById(Long id);
}
