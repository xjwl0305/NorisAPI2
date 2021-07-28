package com.android.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "post")
public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pid")
    public int pid;
    public int uid;
    public String img;
    public String name;
    public String info;
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;
    public double mapX;
    public double mapY;

    public post(int uid, String img, String name, String info, Date createdAt, double mapX, double mapY){
        this.uid = uid;
        this.img = img;
        this.name = name;
        this.info = info;
        this.createdAt = createdAt;
        this.mapX = mapX;
        this.mapY = mapY;
    }
    public post(int uid, String img, String name, String info, double mapX, double mapY){
        this.uid = uid;
        this.img = img;
        this.name = name;
        this.info = info;
        this.mapX = mapX;
        this.mapY = mapY;
    }

    public int getUid() {
        return uid;
    }
    public String getName(){
        return name;
    }

    public post(){}
}
