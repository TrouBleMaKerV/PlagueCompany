package com.nju.service;

import com.nju.entity.Province;
import com.nju.vo.Response;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by thpffcj on 2020/4/5.
 */
public interface ProvinceService {

    Province findProvinceById(Long id);

    List<Province> findAllByProvinceName(String name);

    List<Province> findChinaByDate(String date) throws Exception;

    List<Province> findForeignByDate(String date) throws Exception;
}
