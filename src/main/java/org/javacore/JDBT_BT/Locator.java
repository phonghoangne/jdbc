package org.javacore.JDBT_BT;

public class Locator {
    private int id;
    private String name;
    private String isActive;
    private int x;
    private int y;
    private int z;
    private String created;
    private String createBy;
    private int wareHouseId;

    public Locator() {

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

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
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

    public int getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(int wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    @Override
    public String toString() {
        return "Locator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive='" + isActive + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", created='" + created + '\'' +
                ", createBy='" + createBy + '\'' +
                ", wareHouseId=" + wareHouseId +
                '}';
    }

    public Locator(int id, String name, String isActive, int x, int y, int z, String created, String createBy, int wareHouseId) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.x = x;
        this.y = y;
        this.z = z;
        this.created = created;
        this.createBy = createBy;
        this.wareHouseId = wareHouseId;

    }
}
