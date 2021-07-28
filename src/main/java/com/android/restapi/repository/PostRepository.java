package com.android.restapi.repository;

import com.android.restapi.model.post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface PostRepository extends JpaRepository<post, Integer> {
        @Query("select p from post p")
        List<post> AllPost();
        @Query("select p from post p where p.pid = :pid")
        post findOnePost(int pid);
    }

