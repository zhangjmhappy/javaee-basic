package com.happyghost.myjooqdemo.dao.impl;

import com.happyghost.myjooqdemo.dao.ShopDao;
import com.happyghost.myjooqdemo.entity.Shop;
import com.happyghost.myjooqdemo.jooq.tables.records.ShopRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.happyghost.myjooqdemo.jooq.Tables.SHOP;

public class ShopDaoImpl implements ShopDao {

    @Autowired
    DSLContext dslContext;

    @Override
    public int insertShop(Shop shop) {
        ShopRecord shopRecord = dslContext.newRecord(SHOP);
        shopRecord.setContactName(shop.getContactName());
        shopRecord.setContactPhone(shop.getContactPhone());
        shopRecord.setShopName(shop.getShopName());
        return shopRecord.insert();
    }
}
