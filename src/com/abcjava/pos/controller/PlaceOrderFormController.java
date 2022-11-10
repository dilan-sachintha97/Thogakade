package com.abcjava.pos.controller;

import com.abcjava.pos.db.Database;
import com.abcjava.pos.modal.Customer;
import com.abcjava.pos.modal.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    public TableView tblCart;
    public TableColumn colItemCode;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colQty;
    public TableColumn colTotal;
    public TableColumn colOption;

    public void initialize(){
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
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
    }
}
