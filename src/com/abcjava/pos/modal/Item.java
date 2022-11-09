package com.abcjava.pos.modal;

public class Item {
    private String code;
    private String description;
    private double unitPrice;
    private int atyOnHand;

    public Item(String code, String description, double unitPrice, int atyOnHand) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.atyOnHand = atyOnHand;
    }

    public Item() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAtyOnHand() {
        return atyOnHand;
    }

    public void setAtyOnHand(int atyOnHand) {
        this.atyOnHand = atyOnHand;
    }
}
