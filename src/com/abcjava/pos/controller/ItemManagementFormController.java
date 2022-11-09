package com.abcjava.pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ItemManagementFormController {
    public TextField txtCode;
    public TextField txtDescription;
    public TextField txtUnitPrice;
    public TextField txtQtyOnHand;
    public JFXButton btnSaveItem;
    public TextField txtSearchItem;
    public TableView tblItemDetails;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colOptions;

    public void btnBackToHome(ActionEvent actionEvent) {
    }

    public void btnAddNewitem(ActionEvent actionEvent) {
    }

    public void btnSaveItemOnAction(ActionEvent actionEvent) {
    }
}
