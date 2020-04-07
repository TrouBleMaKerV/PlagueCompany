package com.nju.service;

import com.nju.entity.Province;
import com.nju.vo.Response;

import java.util.List;

/**
 * Created by thpffcj on 2020/4/5.
 */
public interface ProvinceService {

    Province findProvinceById(Long id);

    Response findAllByProvinceName(String name);
}
