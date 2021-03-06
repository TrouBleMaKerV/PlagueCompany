package com.nju.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by thpffcj on 2020/4/5.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city_data")
public class City implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "cityName", nullable = false)
    private String cityName;

    @Basic
    @Column(name = "date", nullable = false)
    private Date date;

    @Basic
    @Column(name = "provName", nullable = false)
    private String provName;

    @Basic
    @Column(name = "confirmedCount", nullable = false)
    private int confirmedCount;

    @Basic
    @Column(name = "suspectedCount", nullable = false)
    private int suspectedCount;

    @Basic
    @Column(name = "curedCount", nullable = false)
    private int curedCount;

    @Basic
    @Column(name = "deadCount", nullable = false)
    private int deadCount;
}
