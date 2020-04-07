package com.nju.controller;

import com.nju.service.ProvinceService;
import com.nju.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by thpffcj on 2020/4/7.
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    @ResponseBody
    @GetMapping("/{name}")
    public Response buildMerchantsInfo(@PathVariable String name) {
        return provinceService.findAllByProvinceName(name);
    }
}
