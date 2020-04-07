package com.nju.service.Impl;

import com.nju.entity.Province;
import com.nju.service.ProvinceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by thpffcj on 2020/4/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProvinceServiceImplTest {

    @Autowired
    ProvinceService provinceService;

    @Test
    public void findAllByProvinceName() {
        List<Province> list = provinceService.findAllByProvinceName("中国".trim());
        System.out.println("---------" + list.size());
        for (Province province : list) {
            System.out.println(province.getProvinceName());
        }
    }

    @Test
    public void findProvinceById() {
        System.out.println(provinceService.findProvinceById(1L));
    }
}