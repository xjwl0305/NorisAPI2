package com.android.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uid")
    public int uid;
    public String id;
    public String password;
    public int phone;
    public int card;
    public int age;
    public int gender;
    public int userType;
    public String address;
    public String nickname;

    public user(String id, String password, int phone, int age, int gender, int userType, String address, String nickname, int card){
        this.id = id;
        this.password = password;
        this.address = address;
        this.nickname = nickname;
        this.card = card;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.userType = userType;
    }
    public user() {
    }

    public int getCard() {
        return card;
    }
    public int getUid(){
        return uid;
    }
    public int getUserType(){
        return this.userType;
    }
}
