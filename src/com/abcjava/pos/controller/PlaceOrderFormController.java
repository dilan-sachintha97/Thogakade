package com.abcjava.pos.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlaceOrderFormController {
    public TextField txtOrderId;
    public TextField txtOrderDate;
    public TextField txtCode11;
    public TextField txtCode111;
    public TextField txtCode1111;
    public TextField txtCode112;
    public TextField txtCode1112;
    public TextField txtCode11111;
    public TextField txtCode11121;

    public void initialize(){
        setOrderDate();
    }

    private void setOrderDate() {
        /*Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = df.format(date);
        txtOrderDate.setText(orderDate);*/

        txtOrderDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) {
    }

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
    }
}
