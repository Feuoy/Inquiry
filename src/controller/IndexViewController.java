package controller;

import model.ProcessData;
import model.SetImage;
import model.SetTableColumn;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.Event;

import java.util.TimerTask;
import java.util.Timer;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class IndexViewController {
    private Boolean isClick = false;
    private SetImage image_0 = new SetImage();

    @FXML
    public  TextField seekData_Fld;
    @FXML
    public  TextField seekImage_Fld;
    @FXML
    public Pane showImage_Pane;
    @FXML
    public Button warning_Btn;

    @FXML
    private TableView<SetTableColumn> data_TableView;
    @FXML
    private TableColumn<SetTableColumn,String> nameCol;
    @FXML
    private TableColumn<SetTableColumn,String> openCol;
    @FXML
    private TableColumn<SetTableColumn,String> lastCloseCol;
    @FXML
    private TableColumn<SetTableColumn,String> priceCol;
    @FXML
    private TableColumn<SetTableColumn,String> todayHighCol;
    @FXML
    private TableColumn<SetTableColumn,String> todayLowCol;

    @FXML
    private TableColumn<SetTableColumn,String> competeToBuyCol;
    @FXML
    private TableColumn<SetTableColumn,String> competeToSellCol;

    @FXML
    private TableColumn<SetTableColumn,String> countCol;
    @FXML
    private TableColumn<SetTableColumn,String> totalCol;

    @FXML
    private TableColumn<SetTableColumn,String> buyApply_1_Col;
    @FXML
    private TableColumn<SetTableColumn,String> buyPrice_1_Col;
    @FXML
    private TableColumn<SetTableColumn,String> sellApply_1_Col;
    @FXML
    private TableColumn<SetTableColumn,String> sellPrice_1_Col;

    @FXML
    private TableColumn<SetTableColumn,String> dateCol;
    @FXML
    private TableColumn<SetTableColumn,String> timeCol;

    @FXML
    private void inputTableColumn(){
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        openCol.setCellValueFactory(cellData -> cellData.getValue().openProperty());
        lastCloseCol.setCellValueFactory(cellData -> cellData.getValue().lastCloseProperty());
        priceCol.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        todayHighCol.setCellValueFactory(cellData -> cellData.getValue().todayHighProperty());
        todayLowCol.setCellValueFactory(cellData -> cellData.getValue().todayLowProperty());

        competeToBuyCol.setCellValueFactory(cellData -> cellData.getValue().competeToBuyProperty());
        competeToSellCol.setCellValueFactory(cellData -> cellData.getValue().competeToSellProperty());

        countCol.setCellValueFactory(cellData -> cellData.getValue().countProperty());
        totalCol.setCellValueFactory(cellData -> cellData.getValue().totalProperty());

        buyApply_1_Col.setCellValueFactory(cellData -> cellData.getValue().buyApply_1_Property());
        buyPrice_1_Col.setCellValueFactory(cellData -> cellData.getValue().buyPrice_1_Property());
        sellApply_1_Col.setCellValueFactory(cellData -> cellData.getValue().sellApply_1_Property());
        sellPrice_1_Col.setCellValueFactory(cellData -> cellData.getValue().sellPrice_1_Property());

        dateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        timeCol.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
    }


    //加入添加数据到tableView
    public void addTableView(ProcessData data){
        data_TableView.setItems(data.getTableColumnData());
    }


    //警告窗口
    public void warn(Stage warningStage) throws Exception{
        Parent root2 = FXMLLoader.load(getClass().getResource("../view/warnView.fxml"));
        warningStage.setTitle("Warning");
        warningStage.setScene(new Scene(root2, 280, 120));
        warningStage.show();
    }
    public void warnWindows() {
        Stage warningStage = new Stage();
        try {
            warn(warningStage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public void warning_Btn(Event event) {
        TryAgainClass eventAgain = new TryAgainClass();
        warning_Btn.setOnAction(eventAgain);
    }
    class TryAgainClass implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {
            Stage stage = (Stage) warning_Btn.getScene().getWindow();
            stage.close();
        }
    }


    //seekData_Btn按钮事件，有bug
    public void seekData_Btn(Event event){
        Timer timer = new Timer();

        if (seekData_Fld.getText().length() >= 6) {
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {

                    ProcessData data = new ProcessData(seekData_Fld.getText());
                    if(seekData_Fld.getText().length() >= 6){

                        if(data.getNoData() == true){
                            warnWindows();
                            seekData_Fld.setText("");
                            data.setNoData();

                            timer.cancel();
                        }
                        else{
                            inputTableColumn();
                            addTableView(data);

                            if (seekData_Fld.getText().length() >= 6 && seekData_Fld.getText().length() != 0){
                                seekImage_Fld.setText(seekData_Fld.getText().substring(0,6));
                            }
                        }
                    }
                }
            },0,2000);
        }
        else {
            warnWindows();
        }
    }


    //seekImage_Btn按钮事件
    public void seekImage_Btn(Event event) {
        if (isClick == false) {
            image_0.setCode("http://image.sinajs.cn/newchart/min/n/sh" + seekImage_Fld.getText() + ".gif");
            image_0.showImageView();
            showImage_Pane.getChildren().add(image_0.getImageView());
            isClick = true;
        }
        else {
            image_0.setCode("http://image.sinajs.cn/newchart/min/n/sh" + seekImage_Fld.getText() + ".gif");
            image_0.changeImageView();
        }
    }


    //分时线
    public void min_Btn(Event event){
        image_0.setCode("http://image.sinajs.cn/newchart/min/n/sh" + seekImage_Fld.getText() + ".gif");
        image_0.changeImageView();
    }
    //日K线
    public void daily_Btn(Event event){
        image_0.setCode("http://image.sinajs.cn/newchart/daily/n/sh" + seekImage_Fld.getText() + ".gif");
        image_0.changeImageView();
    }
    //周K线
    public void weekly_Btn(Event event){
        image_0.setCode("http://image.sinajs.cn/newchart/weekly/n/sh" + seekImage_Fld.getText() + ".gif");
        image_0.changeImageView();
    }
    //月K线
    public void monthly_Btn(Event event) {
        image_0.setCode("http://image.sinajs.cn/newchart/monthly/n/sh" + seekImage_Fld.getText() + ".gif");
        image_0.changeImageView();
    }


}
