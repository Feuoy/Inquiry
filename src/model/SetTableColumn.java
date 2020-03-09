package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SetTableColumn {

    private StringProperty name;//股票名字
    private StringProperty open;//今日开盘价
    private StringProperty close;//昨日收盘价
    private StringProperty price;//当前价格

    private StringProperty todayHigh;//今日最高价
    private StringProperty todayLow;//今日最低价

    private StringProperty competeToBuy;//竞买
    private StringProperty competeToSell;//竞买

    private StringProperty count;//成交股数
    private StringProperty total;//成交金额

    private StringProperty buyApply_1_;//“买一”申请
    private StringProperty buyPrice_1_;//“买一”报价
    private StringProperty sellApply_1_;//“卖一”申请
    private StringProperty sellPrice_1_;//“卖一”报价

    private StringProperty date;//日期
    private StringProperty time;//时间

    public SetTableColumn(){}
    public SetTableColumn(String name, String open, String lastClose, String price,
                          String todayHigh, String todayLow,
                          String competeToBuy, String competeToSell,
                          String count, String total,
                          String buyApply_1_, String buyPrice_1_, String sellApply_1_, String sellPrice_1_,
                          String date, String time){
        this.name = new SimpleStringProperty(name);
        this.open = new SimpleStringProperty(open);
        this.close = new SimpleStringProperty(lastClose);
        this.price = new SimpleStringProperty(price);

        this.todayHigh = new SimpleStringProperty(todayHigh);
        this.todayLow = new SimpleStringProperty(todayLow);

        this.competeToBuy = new SimpleStringProperty(competeToBuy);
        this.competeToSell = new SimpleStringProperty(competeToSell);

        this.count = new SimpleStringProperty(count);
        this.total = new SimpleStringProperty(total);

        this.buyApply_1_ = new SimpleStringProperty(buyApply_1_);
        this.buyPrice_1_ = new SimpleStringProperty(buyPrice_1_);
        this.sellApply_1_ = new SimpleStringProperty(sellApply_1_);
        this.sellPrice_1_ = new SimpleStringProperty(sellPrice_1_);

        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
    }

    public String getName(){
        return name.get();
    }
    public void setName(String name){
        this.name.set(name);
    }
    public StringProperty nameProperty(){
        return name;
    }

    public String getOpen(){
        return open.get();
    }
    public void setOpen(String open){
        this.open.set(open);
    }
    public StringProperty openProperty(){
        return open;
    }

    public String getLastClose(){
        return close.get();
    }
    public void setLastClose(String lastClose){
        this.close.set(lastClose);
    }
    public  StringProperty lastCloseProperty(){
        return  close;
    }

    public String getPrice(){
        return close.get();
    }
    public void setPrice(String price){
        this.price.set(price);
    }
    public StringProperty priceProperty(){
        return price;
    }

    public String getTodayHigh(){
        return todayHigh.get();
    }
    public void setTodayHigh(String todayHigh){
        this.todayHigh.set(todayHigh);
    }
    public StringProperty todayHighProperty(){
        return todayHigh;
    }

    public String getTodayLow(){
        return todayLow.get();
    }
    public void setTodayLow(String todayLow){
        this.todayLow.set(todayLow);
    }
    public StringProperty todayLowProperty(){
        return todayLow;
    }

    public String getCompeteToBuy(){
        return competeToBuy.get();
    }
    public void getCompeteToBuy(String count){
        this.competeToBuy.set(count);
    }
    public StringProperty competeToBuyProperty(){
        return competeToBuy;
    }

    public String getCompeteToSell(){
        return competeToSell.get();
    }
    public void setCompeteToSell(String count){
        this.competeToSell.set(count);
    }
    public StringProperty competeToSellProperty(){
        return competeToSell;
    }

    public String getCount(){
        return count.get();
    }
    public void setCount(String count){
        this.count.set(count);
    }
    public StringProperty countProperty(){
        return count;
    }

    public String getTotal(){
        return total.get();
    }
    public void setTotal(String total){
        this.total.set(total);
    }
    public StringProperty totalProperty(){
        return total;
    }

    public String getBuyApply_1_(){
        return buyApply_1_.get();
    }
    public void setBuyApply_1_(String total){
        this.buyApply_1_.set(total);
    }
    public StringProperty buyApply_1_Property(){
        return buyApply_1_;
    }

    public String geBuyPrice_1_Col(){
        return buyPrice_1_.get();
    }
    public void setBuyPrice_1_Col(String total){
        this.buyPrice_1_.set(total);
    }
    public StringProperty buyPrice_1_Property(){
        return buyPrice_1_;
    }

    public String getSellApply_1_(){
        return sellApply_1_.get();
    }
    public void setSellApply_1_(String total){
        this.sellApply_1_.set(total);
    }
    public StringProperty sellApply_1_Property(){
        return sellApply_1_;
    }

    public String getSellPrice_1_(){
        return sellPrice_1_.get();
    }
    public void setSellPrice_1_(String total){
        this.sellPrice_1_.set(total);
    }
    public StringProperty sellPrice_1_Property(){
        return sellPrice_1_;
    }

    public String getDate(){
        return date.get();
    }
    public void setDate(String date){
        this.date.set(date);
    }
    public StringProperty dateProperty(){
        return date;
    }

    public String getTime(){
        return time.get();
    }
    public void setTime(String time){
        this.date.set(time);
    }
    public StringProperty timeProperty(){
        return time;
    }
}
