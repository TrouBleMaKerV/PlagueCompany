package com.nju.service.Impl;

import com.nju.dao.ProvinceDao;
import com.nju.entity.Province;
import com.nju.service.ProvinceService;
import com.nju.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return provinceDao.findAllByProvinceName(name);
    }
}
