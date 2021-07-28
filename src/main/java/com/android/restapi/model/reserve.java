package com.android.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "reserve")
public class reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rid")
    public int rid;
    public int uid;
    public int pid;
    public int aid;
    public String checkin;
    public String checkout;
    public int roomCount;
    public int adult;
    public int child;
    public int roomType;
    public int pay;
    public int card;
    public int admin_card;
    public String post_name;

    public reserve(int uid, int pid, int aid, String checkin, String checkout, int roomCount, int adult, int child, int roomType, int pay, int card, int admin_card, String post_name){
        this.uid = uid;
        this.pid = pid;
        this.aid = aid;
        this.checkin = checkin;
        this.checkout = checkout;
        this.roomCount = roomCount;
        this.adult = adult;
        this.child = child;
        this.roomType = roomType;
        this.pay = pay;
        this.card = card;
        this.admin_card = admin_card;
        this.post_name = post_name;
    }
    public int getCard(){
        return card;
    }
    public int getPay(){
        return pay;
    }
    public String getPostname(){
        return post_name;
    }
    public int getAid(){
        return aid;
    }
    public int getAdmin_card(){
        return admin_card;
    }
    public reserve(){}
}
