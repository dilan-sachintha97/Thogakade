package com.abcjava.pos.modal.tm;

import javafx.scene.control.Button;

public class ItemTm {
    private String code;
    private String description;
    private double unitPrice;
    private int atyOnHand;
    private Button button;

    public ItemTm() {
    }

    public ItemTm(String code, String description, double unitPrice, int atyOnHand, Button button) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.atyOnHand = atyOnHand;
        this.button = button;
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

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
