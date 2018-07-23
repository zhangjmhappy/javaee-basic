package com.happyghost.myjooqdemo.service;

import com.happyghost.myjooqdemo.entity.Shop;

import java.util.List;

public interface ShopService {
    int insertShop(Shop shop);

    List<Shop> findShops(Shop shop);
}
