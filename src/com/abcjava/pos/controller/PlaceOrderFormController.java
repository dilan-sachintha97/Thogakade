package com.abcjava.pos.controller;

import com.abcjava.pos.db.Database;
import com.abcjava.pos.modal.Customer;
import com.abcjava.pos.modal.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
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
    public ComboBox<String> cmbCustomerId;
    public ComboBox<String>cmbItemId;
    public AnchorPane placeOrderFormContext;

    public void initialize(){
        setOrderDate();
        loadAllCustomersIds();
        loadAllItemsCode();
    }

    private void loadAllItemsCode() {
        for(Item item: Database.itemList){
            cmbItemId.getItems().add(item.getCode());
        }
    }

    private void loadAllCustomersIds() {
        for(Customer c : Database.customerList){
            cmbCustomerId.getItems().add(c.getId());
        }
    }

    private void setOrderDate() {
        /*Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = df.format(date);
        txtOrderDate.setText(orderDate);*/

        txtOrderDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) placeOrderFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashBordForm.fxml"))));
    }

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
    }
}
