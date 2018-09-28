package com.happyghost.myjooqdemo;

import com.happyghost.myjooqdemo.entity.Shop;
import com.happyghost.myjooqdemo.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyjooqdemoApplicationTests {

    @Autowired
    ShopService shopService;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testShopList() {
        List<Shop> shops = shopService.findShops(null);

        for (Shop shop : shops) {
            System.out.println(shop.getShopName());
        }

    }


}
