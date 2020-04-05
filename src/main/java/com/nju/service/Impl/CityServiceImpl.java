package com.nju.service.Impl;

import com.nju.dao.CityDao;
import com.nju.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by thpffcj on 2020/4/5.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;
}
