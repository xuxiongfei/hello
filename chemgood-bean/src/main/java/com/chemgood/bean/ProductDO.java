package com.chemgood.bean;

/**
 * Created by yuyi on 3/12/17.
 * 产品信息
 */
public class ProductDO {

    /**
     * 产品id
     */
    private Long id;

    /**
     * 产品名称
     */
    private String name;

    @Override
    public String toString() {
        return "ProductDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
