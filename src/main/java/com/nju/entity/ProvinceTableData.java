package com.nju.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceTableData {

    private String provinceName;

    private String date;

    // 显存确诊
    private int currentCount;

    // 累计确诊
    private int confirmedCount;

    // 疑似
    private int suspectedCount;

    // 治愈
    private int curedCount;

    // 累计死亡
    private int deadCount;
}
