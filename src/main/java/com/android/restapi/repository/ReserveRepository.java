package com.android.restapi.repository;

import com.android.restapi.model.post;
import com.android.restapi.model.reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ReserveRepository extends JpaRepository<reserve, Integer> {
    @Query("select r from reserve r where r.uid = :uid")
    List<reserve> All_reserve(int uid);
    @Transactional
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query("delete from reserve r where r.uid= :uid and r.pid= :pid")
    int cancel(int uid, int pid);
    @Query("select r from reserve r where r.uid = :uid and r.pid = :pid")
    reserve findOne_reserve(int uid, int pid);
    @Query("select r from reserve r where r.aid = :uid")
    List<reserve> admin_All_reserve(int uid);
}
