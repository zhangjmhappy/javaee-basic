package com.happyghost.myjooqdemo.dao;

import com.happyghost.myjooqdemo.entity.Shop;

import java.util.List;

public interface ShopDao {

    /**
     * 插入店铺对象
     * @param shop
     * @return 店铺对象
     */
    int insertShop(Shop shop);

    List<Shop> findShops(Shop shop);


    /**
     *
     * @param shop
     * @return
     */
    int updateShop(Shop shop);





}
