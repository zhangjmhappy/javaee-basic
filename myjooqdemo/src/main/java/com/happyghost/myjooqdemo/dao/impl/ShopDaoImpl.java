package com.happyghost.myjooqdemo.dao.impl;

import com.happyghost.myjooqdemo.dao.ShopDao;
import com.happyghost.myjooqdemo.entity.Shop;
import com.happyghost.myjooqdemo.jooq.tables.records.ShopRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.happyghost.myjooqdemo.jooq.Tables.SHOP;

@Repository
public class ShopDaoImpl implements ShopDao {

    @Autowired
    private DSLContext dslContext;

    @Override
    public int insertShop(Shop shop) {
        ShopRecord shopRecord = dslContext.newRecord(SHOP);
        shopRecord.setContactName(shop.getContactName());
        shopRecord.setContactPhone(shop.getContactPhone());
        shopRecord.setShopName(shop.getShopName());
        return shopRecord.insert();
    }

    @Override
    public List<Shop> findShops(Shop shop) {
        List<Shop> list = dslContext.selectFrom(SHOP).fetchInto(Shop.class);
        dslContext.select().from(SHOP).orderBy(SHOP.CONTACT_NAME);
        return list;
    }




}
