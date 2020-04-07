package com.nju.controller;

import com.nju.entity.FourData;
import com.nju.entity.Province;
import com.nju.entity.ProvinceTableData;
import com.nju.service.ProvinceService;
import com.nju.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by thpffcj on 2020/4/7.
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    // 返回省的表格数据（包括各个国家的表格数据）
    @ResponseBody
    @GetMapping("/{name}")
    public List<ProvinceTableData> buildMerchantsInfo(@PathVariable String name) {
        List<Province> list = provinceService.findAllByProvinceName(name);

        List<ProvinceTableData> data = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            Province p = list.get(i);

            String provinceName = p.getProvinceName();

            Date date = p.getDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式
            String dateString = format.format(date);
            String[] dateStrings = dateString.split("-");
            String time = dateStrings[1] + "-" + dateStrings[2];

            int confirmedCount = p.getConfirmedCount();
            int suspectedCount = p.getSuspectedCount();
            int curedCount = p.getCuredCount();
            int deadCount = p.getDeadCount();
            int currentCount = confirmedCount - curedCount - deadCount;

            ProvinceTableData provinceTableData = new ProvinceTableData(provinceName, time,
                            currentCount, confirmedCount, suspectedCount, curedCount, deadCount);
            data.add(provinceTableData);
        }

        return data;
    }

    @ResponseBody
    @GetMapping("/{name}")
    public FourData buildFourDataInfo(@PathVariable String name) {
        List<Province> list = provinceService.findAllByProvinceName(name);

        Province p = list.get(0);

        String provinceName = p.getProvinceName();
        int confirmedCount = p.getConfirmedCount();
        int suspectedCount = p.getSuspectedCount();
        int curedCount = p.getCuredCount();
        int deadCount = p.getDeadCount();
        int currentCount = confirmedCount - curedCount - deadCount;

        FourData data = new FourData(provinceName,currentCount,confirmedCount,suspectedCount,curedCount,deadCount);

        return data;
    }
}
