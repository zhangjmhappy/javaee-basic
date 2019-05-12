package com.happyghost.myjooqdemo.controller;

import com.happyghost.myjooqdemo.entity.Shop;
import com.happyghost.myjooqdemo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * shop控制层
 *
 * @author HappyGhost
 * @create 2018-07-24 0:23
 **/
@RestController
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping("shop/add")
    public void insertShop(@RequestBody Shop shop) {
        shopService.insertShop(shop);
    }

    @GetMapping("shops")
    public List<Shop> findShops(Shop shop) {
        System.out.println("test devtool shop====");
        return shopService.findShops(shop);
    }
}
