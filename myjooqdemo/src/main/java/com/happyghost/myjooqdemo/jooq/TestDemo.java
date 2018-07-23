/*
 * This file is generated by jOOQ.
*/
package com.happyghost.myjooqdemo.jooq;


import com.happyghost.myjooqdemo.jooq.tables.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class TestDemo extends SchemaImpl {

    private static final long serialVersionUID = 319415668;

    /**
     * The reference instance of <code>test_demo</code>
     */
    public static final TestDemo TEST_DEMO = new TestDemo();

    /**
     * The table <code>test_demo.shop</code>.
     */
    public final Shop SHOP = com.happyghost.myjooqdemo.jooq.tables.Shop.SHOP;

    /**
     * No further instances allowed
     */
    private TestDemo() {
        super("test_demo", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Shop.SHOP);
    }
}
