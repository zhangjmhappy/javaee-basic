package com.happyghost.myjooqdemo.service.impl;

import com.happyghost.myjooqdemo.dao.ShopDao;
import com.happyghost.myjooqdemo.entity.Shop;
import com.happyghost.myjooqdemo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HappyGhost
 * @create 2018-07-24 0:21
 **/
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopDao shopDao;

    @Override
    public int insertShop(Shop shop) {
        return shopDao.insertShop(shop);
    }

    @Override
    public List<Shop> findShops(Shop shop) {
        return shopDao.findShops(shop);
    }
}
