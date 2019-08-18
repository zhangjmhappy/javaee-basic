/*
 * This file is generated by jOOQ.
*/
package com.happyghost.myjooqdemo.jooq.tables;


import com.happyghost.myjooqdemo.jooq.Indexes;
import com.happyghost.myjooqdemo.jooq.Keys;
import com.happyghost.myjooqdemo.jooq.TestDemo;
import com.happyghost.myjooqdemo.jooq.tables.records.ShopRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Shop extends TableImpl<ShopRecord> {

    private static final long serialVersionUID = -1258084835;

    /**
     * The reference instance of <code>test_demo.shop</code>
     */
    public static final Shop SHOP = new Shop();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ShopRecord> getRecordType() {
        return ShopRecord.class;
    }

    /**
     * The column <code>test_demo.shop.id</code>. 主键ID
     */
    public final TableField<ShopRecord, ULong> ID = createField("id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "主键ID");

    /**
     * The column <code>test_demo.shop.shop_name</code>. 店铺名称
     */
    public final TableField<ShopRecord, String> SHOP_NAME = createField("shop_name", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.VARCHAR)), this, "店铺名称");

    /**
     * The column <code>test_demo.shop.contact_name</code>. 联系人姓名
     */
    public final TableField<ShopRecord, String> CONTACT_NAME = createField("contact_name", org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.VARCHAR)), this, "联系人姓名");

    /**
     * The column <code>test_demo.shop.contact_phone</code>. 联系人手机号码
     */
    public final TableField<ShopRecord, String> CONTACT_PHONE = createField("contact_phone", org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.VARCHAR)), this, "联系人手机号码");

    /**
     * Create a <code>test_demo.shop</code> table reference
     */
    public Shop() {
        this(DSL.name("shop"), null);
    }

    /**
     * Create an aliased <code>test_demo.shop</code> table reference
     */
    public Shop(String alias) {
        this(DSL.name(alias), SHOP);
    }

    /**
     * Create an aliased <code>test_demo.shop</code> table reference
     */
    public Shop(Name alias) {
        this(alias, SHOP);
    }

    private Shop(Name alias, Table<ShopRecord> aliased) {
        this(alias, aliased, null);
    }

    private Shop(Name alias, Table<ShopRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return TestDemo.TEST_DEMO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SHOP_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ShopRecord, ULong> getIdentity() {
        return Keys.IDENTITY_SHOP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ShopRecord> getPrimaryKey() {
        return Keys.KEY_SHOP_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ShopRecord>> getKeys() {
        return Arrays.<UniqueKey<ShopRecord>>asList(Keys.KEY_SHOP_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Shop as(String alias) {
        return new Shop(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Shop as(Name alias) {
        return new Shop(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Shop rename(String name) {
        return new Shop(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Shop rename(Name name) {
        return new Shop(name, null);
    }
}
