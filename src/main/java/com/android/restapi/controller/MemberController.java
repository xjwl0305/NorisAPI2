package com.android.restapi.controller;

import com.android.restapi.model.*;
import com.android.restapi.repository.BankRepository;
import com.android.restapi.repository.MemberRepository;
import com.android.restapi.repository.PostRepository;
import com.android.restapi.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.websocket.Session;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/project3")
@RestController
public class MemberController {

    @Autowired
    public MemberRepository memberRepository;

    @Autowired
    public PostRepository postRepository;

    @Autowired
    public BankRepository bankRepository;

    @Autowired
    public ReserveRepository reserveRepository;

    @GetMapping("/view")
    public List<user> view(){
        return memberRepository.findAll();
    }
    @RequestMapping("/login")
    public response login(@RequestBody Map<String, Object> param){
        String id = (String) param.get("id");
        String password = (String) param.get("password");
        List<user> find = memberRepository.findUser(id, password);
        response res = new response();
        if(find.size() > 0) {
            res.setStatus("success");
            res.setCard(find.get(0).getCard());
            res.setUid(find.get(0).getUid());
            res.setUserType(find.get(0).getUserType());
            return res;
        }else{
            res.setStatus("failed");
            return res;
        }
    }
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
    @RequestMapping("/signup")
    public response signup(@RequestBody Map<String, Object> param){
        String id = (String) param.get("id");
        String password = (String) param.get("password");
        String name = (String) param.get("name");
        String phone = (String) param.get("phone");
        String gender = (String) param.get("gender");
        String card = (String) param.get("card");
        String userType = (String) param.get("userType");
        String age = (String) param.get("age");
        String address = (String) param.get("address");
        response res = new response();
        memberRepository.save(
                new user(id, password, Integer.parseInt(phone), Integer.parseInt(age), Integer.parseInt(gender), Integer.parseInt(userType), address, name, Integer.parseInt(card))
        );
        res.setStatus("success");
        return res;
    }

    @RequestMapping("/postList")
    public List<post> postList(){
        List<post> list = postRepository.AllPost();
        return list;
    }
    @RequestMapping("/viewMoney")
    public card_response viewMoney(@RequestBody Map<String, Object> param){
        String id = (String) param.get("cid");
        int cid = Integer.parseInt(id);
        bank bank = new bank();
        bank = bankRepository.findMoney(cid);
        int money = bank.getMoney();
        card_response res = new card_response();
        res.setMoney(money);
        return res;
    }
    @RequestMapping("/reserve")
    public response reserve(@RequestBody Map<String, Object> param){
        String uid = (String) param.get("uid");
        String pid = (String) param.get("pid");
        String aid = (String) param.get("aid");
        String checkin = (String) param.get("checkin");
        String checkout = (String) param.get("checkout");
        String roomCount = (String) param.get("roomCount");
        String adult = (String) param.get("adult");
        String child = (String) param.get("child");
        String roomType = (String) param.get("roomType");
        String price = (String) param.get("price");
        String cid = (String) param.get("cid");
        String admin_card = (String) param.get("admin_card");
        String post_name = (String) param.get("post_name");

        response res = new response();
        bank bank = new bank();
        bank = bankRepository.findMoney(Integer.parseInt(cid));
        int money = bank.getMoney();
        money = money - Integer.parseInt(price);
        int paying = bankRepository.Pay(money, Integer.parseInt(cid));
        int selling = bankRepository.Sell(Integer.parseInt(price), Integer.parseInt(admin_card));
        reserveRepository.save(
                new reserve(Integer.parseInt(uid), Integer.parseInt(pid), Integer.parseInt(aid), checkin, checkout, Integer.parseInt(roomCount),
                        Integer.parseInt(adult), Integer.parseInt(child), Integer.parseInt(roomType), Integer.parseInt(price), Integer.parseInt(cid), Integer.parseInt(admin_card),
                        post_name)
        );
        res.setStatus("success");
        return res;
    }
    @RequestMapping("/mylist")
    public List<reserve> mylist(@RequestBody Map<String, Object> param){
        String uid = (String) param.get("uid");
        List<reserve> mylist = reserveRepository.All_reserve(Integer.parseInt(uid));
        return mylist;
    }
    @RequestMapping("/cancel")
    public response cancel(@RequestBody Map<String, Object> param){
        String uid = (String) param.get("uid");
        String pid = (String) param.get("pid");
        reserve reserve = new reserve();
        reserve = reserveRepository.findOne_reserve(Integer.parseInt(uid), Integer.parseInt(pid));
        int card = reserve.getCard();
        int pay = reserve.getPay();
        int bank_cancel = bankRepository.cancel(pay, card);
        int cancel = reserveRepository.cancel(Integer.parseInt(uid), Integer.parseInt(pid));
        response res = new response();
        res.setStatus("success");
        return res;
    }
    @RequestMapping("/write")
    public response write(@RequestBody Map<String, Object> param){
        String uid = (String) param.get("uid");
        String name = (String) param.get("name");
        String img = (String) param.get("img");
        String info = (String) param.get("info");
        String mapX = (String) param.get("mapX");
        String mapY = (String) param.get("mapY");
        postRepository.save(
                new post(Integer.parseInt(uid), img, name, info, Double.parseDouble(mapX), Double.parseDouble(mapY))
        );
        response res = new response();
        res.setStatus("success");
        return res;
    }
    @RequestMapping("/getAdmin")
    public response getAdmin(@RequestBody Map<String, Object> param){
        String pid = (String) param.get("pid");
        post post = postRepository.findOnePost(Integer.parseInt(pid));
        int uid = post.getUid();
        String post_name = post.getName();
        user user = memberRepository.findOneUser(uid);
        int card = user.getCard();
        response res = new response();
        res.setStatus("success");
        res.setUid(uid);
        res.setCard(card);
        res.setPost_name(post_name);
        return res;
    }
    @RequestMapping("/Adminmylist")
    public List<reserve> adminMyList(@RequestBody Map<String, Object> param){
        String uid = (String) param.get("uid");
        List<reserve> reserve_list = reserveRepository.admin_All_reserve(Integer.parseInt(uid));
        return reserve_list;
    }
}
