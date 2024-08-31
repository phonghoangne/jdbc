package org.javacore.JDBT_BT;

import java.sql.Timestamp;

public class WareHouse {
    private int id;
    private String name;
    private String isActive;
    private String description;
    private String createBy;
    private String created;

    public WareHouse() {

    }


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

    public String isActive() {
        return isActive;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setActive(String active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public WareHouse(int id, String name, String isActive, String description, String createBy, String created) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.description = description;
        this.createBy = createBy;
        this.created = created;
    }

    @Override
    public String toString() {
        return "WareHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive='" + isActive + '\'' +
                ", description='" + description + '\'' +
                ", createBy='" + createBy + '\'' +
                ", created=" + created +
                '}';
    }
}
