package com.android.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "bank")
public class bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cid")
    int cid;
    int money;
    public bank(){}

    public int getCid() {
        return cid;
    }
    public int getMoney() {
        return money;
    }
}
