package com.android.restapi.model;

import lombok.Getter;
import lombok.Setter;

public class response {
    public String status;
    public int card;
    public int uid;
    public int userType;
    public String post_name;


    public response(){}
    public void setStatus(String status){
        this.status = status;
    }
    public void setCard(int card) {
        this.card = card;
    }
    public void setUid(int uid){this.uid = uid;}
    public void setUserType(int userType){this.userType = userType;}
    public void setPost_name(String post_name){this.post_name = post_name;}
    public String getStatus(){
        return this.status;
    }
    public int getUserType(){return this.userType;}
    public int getUid() {
        return uid;
    }

    public int getCard() {
        return card;
    }
}
