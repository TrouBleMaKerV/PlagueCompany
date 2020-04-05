package com.nju.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by thpffcj on 2020/4/5.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "province")
public class Province {

    @Id
    @Column(name = "id", nullable = false)
    String provName;

    @Basic
    @Column(name = "plan_name", nullable = false)
    int confirmedCount;
    int suspectedCount;
    int curedCount;
    int deadCount;
    String date;
}
