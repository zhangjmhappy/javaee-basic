package com.happyghost.basicjava.immutableclass;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 *
 */
public class TestClass {



    //使用方法
    public static Unsafe getUnsafeInstance() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }


    public static void main(String[] args) {
        String str = "Hello";
        Unsafe unsafe = null;
        try {
            unsafe = getUnsafeInstance();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            TestClass.printAddresses("str", str);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        str += "world";
        System.out.println(unsafe);
        //System.out.println(str);
        try {
            TestClass.printAddresses("str",str);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }




    }

    public static void printAddresses(String label, Object... objects) throws NoSuchFieldException, IllegalAccessException {

        Unsafe unsafe = getUnsafeInstance();
        System.out.print(label +": 0x");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        boolean is64bit = true;
        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                System.out.print(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last)
                        System.out.print(", +" + Long.toHexString(i2 - last));
                    else
                        System.out.print(", -" + Long.toHexString( last - i2));
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        System.out.println();
    }

    public long location(Object object) throws Throwable {
        Unsafe unsafe = getUnsafeInstance();
        Object[] array = new Object[]{object};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long location;
        switch (addressSize) {
            case 4:
                location = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                location = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }
        return (location);
    }
}
