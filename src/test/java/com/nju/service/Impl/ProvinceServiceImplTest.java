package com.nju.service.Impl;

import com.nju.service.ProvinceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by thpffcj on 2020/4/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProvinceServiceImplTest {

    @Autowired
    ProvinceService provinceService;

    @Test
    public void findProvinceById() {
        System.out.println(provinceService.findProvinceById(1L));
    }
}