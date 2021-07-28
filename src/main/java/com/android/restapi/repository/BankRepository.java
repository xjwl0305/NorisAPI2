package com.android.restapi.repository;

import com.android.restapi.model.bank;
import com.android.restapi.model.post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BankRepository extends JpaRepository<bank, Integer> {
    @Query("select b from bank b where b.cid= :cid")
    bank findMoney(int cid);
    @Transactional
    @Modifying
    @Query("update bank b set b.money = :price where b.cid = :cid")
    int Pay(int price, int cid);
    @Transactional
    @Modifying
    @Query("update bank b set b.money = b.money+:price where b.cid = :aid")
    int Sell(int price, int aid);
    @Transactional
    @Modifying
    @Query("update bank b set b.money = b.money+:pay where b.cid = :cid")
    int cancel(int pay, int cid);
}
