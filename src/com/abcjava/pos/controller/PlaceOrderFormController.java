package com.abcjava.pos.controller;

import com.abcjava.pos.db.Database;
import com.abcjava.pos.modal.Customer;
import com.abcjava.pos.modal.Item;
import com.abcjava.pos.modal.tm.CartTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlaceOrderFormController {
    public TextField txtOrderId;
    public TextField txtOrderDate;
    public ComboBox<String> cmbCustomerId;
    public ComboBox<String>cmbItemId;
    public AnchorPane placeOrderFormContext;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public TextField txtDescription;
    public TextField txtUnitPrice;
    public TextField txtQty;
    public TextField txtQtyOnHand;
    public TableView<CartTm> tblCart;
    public TableColumn<CartTm,String> colItemCode;
    public TableColumn<CartTm,String>  colDescription;
    public TableColumn<CartTm,Double>  colUnitPrice;
    public TableColumn<CartTm,Integer>  colQty;
    public TableColumn<CartTm,Double>  colTotal;
    public TableColumn<CartTm,Button>  colOption;

    public void initialize(){

        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("button"));


        setOrderDate();
        loadAllCustomersIds();
        loadAllItemsCode();

        cmbCustomerId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(null != newValue){
                setCustomerDetailsToTextFields();
            }
        });

        cmbItemId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(null != newValue){
                setItemDetailsToTextFields();
            }
        });
    }

    private void setItemDetailsToTextFields() {
        for(Item item : Database.itemList){
            if(item.getCode().equals(cmbItemId.getValue())){
                txtDescription.setText(item.getDescription());
                txtUnitPrice.setText(String.valueOf(item.getUnitPrice()));
                txtQtyOnHand.setText(String.valueOf(item.getQtyOnHand()));

            }
        }
    }

    private void setCustomerDetailsToTextFields() {
        for(Customer c :Database.customerList){
            if(c.getId().equals(cmbCustomerId.getValue())){
                txtName.setText(c.getName());
                txtAddress.setText(c.getAddress());
                txtSalary.setText(String.valueOf(c.getSalary()));
            }
        }
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
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());
        double total = unitPrice* qty;
        Button button = new Button("Delete");

        CartTm cartTm = new CartTm(cmbItemId.getValue(),txtDescription.getText(),unitPrice,qty,total,button);

        ObservableList<CartTm> obList = FXCollections.observableArrayList();
        obList.add(cartTm);

        tblCart.setItems(obList);

    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
    }
}
