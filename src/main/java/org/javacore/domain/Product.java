package org.javacore.domain;

import java.sql.Timestamp;

public class Product {
    private int id;
    private String name;
    private String isActive;
    private String created;
    private String createBy;
    private int qtyStock;
    private String productType;
    private Integer productparentId;

    public Product(int id, String name, String isActive, String created, String createBy, int qtyStock, String productType, Integer productparentId) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.created = created;
        this.createBy = createBy;
        this.qtyStock = qtyStock;
        this.productType = productType;
        this.productparentId = productparentId;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public String getIsActive() {
        return isActive;
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

    public String isActive() {
        return isActive;
    }

    public void setActive(String active) {
        isActive = active;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public int getQtyStock() {
        return qtyStock;
    }

    public void setQtyStock(int qtyStock) {
        this.qtyStock = qtyStock;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getProductparentId() {
        return productparentId;
    }

    public void setProductparentId(Integer productparentId) {
        this.productparentId = productparentId;
    }

    public void setInt(int id) {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive='" + isActive + '\'' +
                ", created='" + created + '\'' +
                ", createBy='" + createBy + '\'' +
                ", qtyStock=" + qtyStock +
                ", productType='" + productType + '\'' +
                ", productparentId=" + productparentId +
                '}';
    }


}
