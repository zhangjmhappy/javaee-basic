package com.happyghost.junit;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * 1.@BeforeClass修饰的方法会在所有的方法被调用前被执行，而且改方法是静态的，所以当测试类被加载后接着就会运行它，而且在内存
 *      中它，而且在内存中它只会存在一份实例，它比较适合加载配置文件
 * 2.@AfterClass所修饰的方法通常用来对资源的清理，如关闭数据库连接
 * 3.@Before和@After会在每个测试方法的前后各执行一次。
 */
public class CalculateTest3 {

    @Before
    public void setUp() throws Exception {
        System.out.println("this is before...");
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("this is beforeClass...");
    }



    @After
    public void tearDown() throws Exception {
        System.out.println("this is after...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("this is afterClass...");
    }


    @Test
    public void test01() {
        System.out.println("this is method test01()");
    }

    @Test
    public void test02() {
        System.out.println("this is mehtod test02()");
    }
}