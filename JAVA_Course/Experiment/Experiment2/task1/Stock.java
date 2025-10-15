package Experiment.Experiment2.task1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol,String name,double previousClosingPrice,double currentPrice){
        this.symbol=symbol;
        this.name=name;
        this.previousClosingPrice=previousClosingPrice;
        this.currentPrice=currentPrice;
    }
    public String getSymbol() {
        return symbol;
    }
    public String getName(){
        return name;
    }
    public double getPreviousClosingPrice(){
        return previousClosingPrice;
    }
    public void setPreviousClosingPrice(double previousClosingPrice){
        this.previousClosingPrice=previousClosingPrice;
    }
    public double getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(double currentPrice){
        this.currentPrice=currentPrice;
    }
    public double getChangePercent(){
        return (currentPrice-previousClosingPrice)/previousClosingPrice;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        DecimalFormat df=new DecimalFormat("0.00%");

        System.out.println("输入股票代码:");
        String symbol=sc.next();
        System.out.println("输入股票名称:");
        String name=sc.next();
        System.out.println("输入股票昨日收盘价:");
        double previousclosingprice=sc.nextDouble();
        System.out.println("输⼊股票当前价格:");
        double currentprice=sc.nextDouble();
        Stock stock=new Stock("0001","XXX公司",previousclosingprice,currentprice);
        double rate=stock.getChangePercent();

        System.out.println("股票跌涨幅:"+df.format(rate));

    }
}
