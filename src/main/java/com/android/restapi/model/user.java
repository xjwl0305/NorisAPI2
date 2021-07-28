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
    public String Name;
    public String id;
    public String password;
    public String email;
    public String phone;
    public String company;

    public user(String Name, String id, String password, String email, String phone, String company){
        this.Name = Name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }
    public user() {
    }
}
