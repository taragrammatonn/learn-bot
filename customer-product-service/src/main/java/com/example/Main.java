package com.example;

import com.example.dao.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@SpringBootApplication
public class Main {

    public static void main(String[] args) {
//        SpringApplication.run(Main.class, args);
        String s = new String();
        var user = new User(1L, "qwe", "qwe");

        Map<String, String> map = new HashMap<>();
        map.put(null, "123");
        map.put("null", "123");
        map.put(null, "1111");

        System.out.println(map);



    }
}