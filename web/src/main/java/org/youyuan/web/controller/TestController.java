package org.youyuan.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youyuan.web.bean.Person;
import org.youyuan.web.bean.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Describe
 * @Author youjiancheng
 * @Date 2021/1/25 14:33
 */
@RestController
@Slf4j
@RequestMapping("/json")
public class TestController {

    @GetMapping("/test")
    public void test() {
        String json = "{\"code\": 200,\"data\": {\"name\": \"zs\",\"age\": 20" + "}}";

        JSONObject jsonObject = JSONObject.parseObject(json);
        Object data = jsonObject.get("data");
        User user = JSONObject.parseObject(data.toString(),new TypeReference<User>(){});
        log.info("{}",user);
        log.info("{}",data);

    }

    @GetMapping("/test1")
    public void test1() {
        User user = new User();
        Person person = new Person();

        //向上转型
        Person person1 = user;

        //向下转型
        User user1 = (User) person;
    }

    @GetMapping("/test2")
    public void test2() {
        log.info(System.getProperty("user.dir"));
    }

    @GetMapping("/test/encode")
    public void testEncode(HttpServletResponse response, HttpServletRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyyMMddHHmmss");
        String filename = "视频分析任务结果导出_"+ sdf.format(new Date()) +".xlsx";

    }

}
