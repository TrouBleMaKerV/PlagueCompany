package com.nju.service.Impl;

import com.nju.dao.ProvinceDao;
import com.nju.entity.Province;
import com.nju.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by thpffcj on 2020/4/5.
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceDao provinceDao;

    @Override
    public Province findProvinceById(Long id) {
        return provinceDao.findProvinceById(id);
    }

    public static void main(String[] args) {
        ProvinceServiceImpl p = new ProvinceServiceImpl();
        p.findProvinceById(1L);
    }
}
