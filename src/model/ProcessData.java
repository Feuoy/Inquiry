package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.HttpURLConnection;
import java.net.URL;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public  class ProcessData {

    private String originStr;
    private Boolean noData = false;
    private ObservableList<SetTableColumn> tableColumnData = FXCollections.observableArrayList();


    public ProcessData(){}
    public ProcessData(String originStr){
        this.originStr = originStr;
        circle(originStr);
    }
    public Boolean getNoData(){
        return noData;
    }
    public void setData(){
        this.noData = true;
    }
    public void setNoData(){
        this.noData = false;
    }

    public ObservableList<SetTableColumn> getTableColumnData(){
        return this.tableColumnData;
    }
    public void setTableColumnData(ObservableList<SetTableColumn> tableColumnData) {
        this.tableColumnData = tableColumnData;
    }


    //获取股票网址字符串,转为字符串数组
    public  String[] getData(String httpArg){
        String httpUrl = "http://hq.sinajs.cn/list=sh"  + httpArg;
        String originStr = null;

        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "GBK"));

            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead + "\n");
            }

            originStr = sbf.toString();
            reader.close();

            String[] arrayStr;
            int begin = originStr.indexOf("\"");
            String temp = originStr.substring(begin + 1,originStr.length());
            arrayStr = temp.split(",");

            return arrayStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //添加数据到tableColumn
    public void addData(String[] finalStr) {
        tableColumnData.add(new SetTableColumn(finalStr[0],finalStr[1],finalStr[2],finalStr[3],finalStr[4],finalStr[5],
                finalStr[6],finalStr[7],finalStr[8],finalStr[9],finalStr[10],finalStr[11],finalStr[20],finalStr[21],finalStr[30],finalStr[31]));
    }


    //处理seekData_Fld的输入，几组调用几次getData
    public void circle(String inputStr){

        String[] inputStr_to_Array = inputStr.split("[,，]");
        for (int i = 0; i < inputStr_to_Array.length ; i++){
            String finalStr[] = getData(inputStr_to_Array[i]);

            if(finalStr.length == 1){
                setNoData();
            }
            else{
                addData(finalStr);
            }
        }
    }


}
