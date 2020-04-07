package com.nju.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProvinceTableData {
    private String provinceName;

    private String date;

    private int confirmedCount;

    private int suspectedCount;

    private int curedCount;

    private int deadCount;

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setConfirmedCount(int confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public void setSuspectedCount(int suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public void setCuredCount(int curedCount) {
        this.curedCount = curedCount;
    }

    public void setDeadCount(int deadCount) {
        this.deadCount = deadCount;
    }
}
