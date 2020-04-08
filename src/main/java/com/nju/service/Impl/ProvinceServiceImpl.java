package com.nju.service.Impl;

import com.nju.dao.ProvinceDao;
import com.nju.entity.Province;
import com.nju.entity.ProvinceTableData;
import com.nju.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by thpffcj on 2020/4/5.
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

    private static Set<String> set = new HashSet<>();
    static {
        String province = "河北省、山西省、辽宁省、吉林省、黑龙江省、江苏省、浙江省、安徽省、福建省、江西省、山东省、河南省、" +
                "湖北省、湖南省、广东省、海南省、四川省、贵州省、云南省、陕西省、甘肃省、青海省、台湾省、"+
                "内蒙古自治区、广西壮族自治区、西藏自治区、宁夏回族自治区、新疆维吾尔自治区、"+
                "北京市、天津市、上海市、重庆市";
        Collections.addAll(set, province.split("、"));
    }

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

    @Override
    public List<Province> findChinaByDate(String date) throws Exception {
        Set<String> s = new HashSet<>();
        List<Province> list = provinceDao.findAll().stream().
                filter(province -> set.contains(province.getProvinceName())) .collect(Collectors.toList());
        List<Province> result = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            Province p = list.get(i);
            String provinceName = p.getProvinceName();
            if (s.contains(provinceName)) {
                continue;
            }
            s.add(provinceName);
            result.add(p);
        }

        return result;
    }

    @Override
    public List<Province> findForeignByDate(String date) throws Exception {
        Set<String> s = new HashSet<>();
        List<Province> list = provinceDao.findAll().stream().
                filter(province -> !set.contains(province.getProvinceName())) .collect(Collectors.toList());
        List<Province> result = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            Province p = list.get(i);
            String provinceName = p.getProvinceName();
            if (s.contains(provinceName)) {
                continue;
            }
            s.add(provinceName);
            result.add(p);
        }

        return result;
    }
}
