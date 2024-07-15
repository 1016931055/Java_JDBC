package com.druid.example;

//实体类
public class Brand {
    private int id;
    private String brandName;
    private String conpanyName;
    private int ordered;
    private String description;
    private int status;

    public Brand() {
    }

    public Brand(int id, String brandName, String conpanyName, int ordered, String description, int status) {
        this.id = id;
        this.brandName = brandName;
        this.conpanyName = conpanyName;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", conpanyName='" + conpanyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getConpanyName() {
        return conpanyName;
    }

    public void setConpanyName(String conpanyName) {
        this.conpanyName = conpanyName;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
