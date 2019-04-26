package com.happyghost.gson;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * https://www.jianshu.com/p/0e40a52c0063
 */

public class Category {
    @Expose
    public int id;
    @Expose
    public String name;
    @Expose
    public List<Category> children;
    //不需要序列化,所以不加 @Expose 注解，
    //等价于 @Expose(deserialize = false,serialize = false)
    public Category parent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}

