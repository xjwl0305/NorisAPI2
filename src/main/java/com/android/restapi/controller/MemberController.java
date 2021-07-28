package com.android.restapi.controller;

import com.android.restapi.model.*;
//import com.android.restapi.repository.BankRepository;
import com.android.restapi.repository.MemberRepository;
//import com.android.restapi.repository.PostRepository;
//import com.android.restapi.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.websocket.Session;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/NorisAPI")
@RestController
public class MemberController {

    @Autowired
    public MemberRepository memberRepository;

    @RequestMapping("/checkID")
    public response checkID(@RequestBody Map<String, Object> param){
        String id = (String) param.get("id");
        List<user> find = memberRepository.checkID(id);
        response res = new response();
        if(find.size() > 0) {
            res.setStatus("failed");
            return res;
        }else{
            res.setStatus("success");
            return res;
        }
    }
}
