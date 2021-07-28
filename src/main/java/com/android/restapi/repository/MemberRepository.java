package com.android.restapi.repository;

import com.android.restapi.model.post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.android.restapi.model.user;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<user, Integer> {
    @Query("select u from user u where u.id= :id and u.password= :password")
    List<user> findUser(String id, String password);
    @Query("select u from user u where u.id= :id")
    List<user> checkID(String id);
    @Query("select u from user u where u.uid= :uid")
    user findOneUser(int uid);

//    @Modifying
//    @Query("insert INTO user (id, password, name, phone, card, age, address, gender, userType)" +
//            "VALUES(:id, :password, :name, :phone, :card, :age, :address, :gender, :userType)")
//    @Transactional
//    void signup(String id, String password, String name, int phone, int card, int age, String address, int gender, int userType);
}
