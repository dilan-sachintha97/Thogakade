package com.abcjava.pos.controller;

import com.abcjava.pos.db.Database;
import com.abcjava.pos.modal.Order;
import com.abcjava.pos.view.tm.OderTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Date;

public class OderDetailsFormController {

    public TableView<OderTm> tblOderDetails;
    public TableColumn<OderTm,String> colOderId;
    public TableColumn<OderTm,String>  colCustomer;
    public TableColumn<OderTm, Date>  colDate;
    public TableColumn<OderTm,Double>  colTotal;
    public TableColumn<OderTm,Button>  colOptions;
    public AnchorPane oderDetailsFormContext;

    public void initialize(){
        ObservableList<OderTm> obsOderList = FXCollections.observableArrayList();
        for(Order order : Database.ordersList){
            Button btn = new Button("View more");
            OderTm oderTm = new OderTm(order.getOrderId(), order.getCustomer(), order.getDate(), order.getTotalCost(),btn);
            obsOderList.add(oderTm);
        }
        tblOderDetails.setItems(obsOderList);
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) oderDetailsFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashBordForm.fxml"))));
    }
}
