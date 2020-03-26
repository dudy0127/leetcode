package io.github.dudy.leecode;

public class GridModel {
    private static final int BUY_NUM;
    private static final double MAX_PROFIT_RUN_PRICE;
    private static final double MAX_PROFIT_RUN_PERCENT;

    private static final double BASE_AMOUNT;


    static {
        //Setting setting = SettingUtil.get("grid.properties");
        BUY_NUM = 9800;
        MAX_PROFIT_RUN_PRICE = 1.020;
        MAX_PROFIT_RUN_PERCENT = 45;
        BASE_AMOUNT = 10000;
    }
    private double level;
    private double buyPrice;
    private double buyNum;
    private double buyPriceSum;
    private double sellPrice;
    private int sellNum;
    private double sellPriceSum;
    private double profit;
    private double profitPercentage;
    private int leftNum;
    private double leftProfitSellPrice;



    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(double buyNum) {
        this.buyNum = buyNum;
    }

    public double getBuyPriceSum() {
        return buyPriceSum;
    }

    public void setBuyPriceSum(double buyPriceSum) {
        this.buyPriceSum = buyPriceSum;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
        this.sellNum = sellNum;
    }

    public double getSellPriceSum() {
        return sellPriceSum;
    }

    public void setSellPriceSum(double sellPriceSum) {
        this.sellPriceSum = sellPriceSum;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(double profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public int getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(int leftNum) {
        this.leftNum = leftNum;
    }

    public double getLeftProfitSellPrice() {
        return leftProfitSellPrice;
    }

    public void setLeftProfitSellPrice(double leftProfitSellPrice) {
        this.leftProfitSellPrice = leftProfitSellPrice;
    }

    public static GridModel createOneGrid(double buyPrice, double sellPrice, double buyLevel) {
        GridModel gridModel = new GridModel();
        gridModel.setLevel(buyLevel);
        gridModel.setBuyPrice(buyPrice);
        double buyNum = Math.floor(BASE_AMOUNT * (2-buyLevel) / buyPrice/ 100) * 100 ;
        gridModel.setBuyNum(buyNum);
        //gridModel.setBuyNum(num * 100);

        gridModel.setBuyPriceSum(buyPrice * gridModel.getBuyNum());
        gridModel.setSellPrice(sellPrice);
        int leftNum = calLeftProfitNum(buyPrice, sellPrice,buyNum);
        gridModel.setLeftNum(leftNum);
        gridModel.setSellNum((int)Math.floor(BASE_AMOUNT / sellPrice/ 100) * 100);
        gridModel.setSellPriceSum(sellPrice * gridModel.getSellNum());
        gridModel.setLeftProfitSellPrice(calLeftProfitSellPrice(sellPrice));
        double finalProfit = leftNum * gridModel.getLeftProfitSellPrice() + sellPrice *
                gridModel.getSellNum() - buyPrice * BUY_NUM;
        gridModel.setProfit(finalProfit);

        gridModel.setProfitPercentage(gridModel.getProfit() / gridModel.getBuyPriceSum() * 100);
        return gridModel;
    }

    /**
     * 留利润数量
     * @param buyPrice
     * @param sellPrice
     * @param buyNum
     * @return
     */
    private static int calLeftProfitNum(double buyPrice, double sellPrice, double buyNum) {
        double spread = sellPrice - buyPrice;
        double profit = spread * buyNum;
        return (int) (profit / sellPrice);
    }

    /**
     * 获取保留利润的出售价格
     */
    private static double calLeftProfitSellPrice(double sellPrice) {
        double leftSellPrice = sellPrice * (100 + MAX_PROFIT_RUN_PERCENT) / 100;
        return Math.min(leftSellPrice, MAX_PROFIT_RUN_PRICE);
    }

}