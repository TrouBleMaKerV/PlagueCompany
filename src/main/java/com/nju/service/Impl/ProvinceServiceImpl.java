package com.nju.service.Impl;

import com.nju.dao.ProvinceDao;
import com.nju.entity.Province;
import com.nju.service.ProvinceService;
import com.nju.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Province> findAllByProvinceName(String name){
        List<Province> list = new ArrayList<>();
        list = provinceDao.findAll().stream().filter(province -> province.getProvinceName().equals(name)).collect(Collectors.toList());
        return list;
    }
}
