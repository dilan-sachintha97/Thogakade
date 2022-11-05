package com.abcjava.pos.controller;

import com.abcjava.pos.db.Database;
import com.abcjava.pos.modal.Customer;
import com.abcjava.pos.view.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class CustomerManagementFormController {
    public AnchorPane customerManagementContext;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public TableView<CustomerTm> tblCustomerDetails;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOptions;

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOptions.setCellValueFactory(new PropertyValueFactory<>("button"));
    }

    private void searchCustomers(){
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();
        for (Customer c : Database.customerList){
            Button button = new Button("Delete");
            CustomerTm customerTm = new CustomerTm(
                    c.getId(),c.getName(),c.getAddress(),c.getSalary(),button
            );
            tmList.add(customerTm);
        }
        tblCustomerDetails.setItems(tmList);
    }

    public void btnSaveCustomerOnAction(ActionEvent actionEvent) {

        Customer customer = new Customer(
                txtId.getText(),txtName.getText(),txtAddress.getText(),Double.parseDouble(txtSalary.getText())
        );
        boolean isSaved = Database.customerList.add(customer);  // save customer in arrayList
        if(isSaved){
            searchCustomers();
            new Alert(Alert.AlertType.INFORMATION, "Customer Saved").show();
        }else{
            new Alert(Alert.AlertType.WARNING, "Something Wrong!").show();
        }
    }
}

