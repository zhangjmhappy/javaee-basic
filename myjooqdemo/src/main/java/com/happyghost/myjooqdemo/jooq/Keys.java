/*
 * This file is generated by jOOQ.
*/
package com.happyghost.myjooqdemo.jooq;


import com.happyghost.myjooqdemo.jooq.tables.Shop;
import com.happyghost.myjooqdemo.jooq.tables.records.ShopRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;
import org.jooq.types.ULong;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>test_demo</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<ShopRecord, ULong> IDENTITY_SHOP = Identities0.IDENTITY_SHOP;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ShopRecord> KEY_SHOP_PRIMARY = UniqueKeys0.KEY_SHOP_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<ShopRecord, ULong> IDENTITY_SHOP = Internal.createIdentity(Shop.SHOP, Shop.SHOP.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<ShopRecord> KEY_SHOP_PRIMARY = Internal.createUniqueKey(Shop.SHOP, "KEY_shop_PRIMARY", Shop.SHOP.ID);
    }
}
