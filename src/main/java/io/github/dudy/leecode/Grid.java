package io.github.dudy.leecode;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.sarojaba.prettytable4j.PrettyTable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static io.github.dudy.leecode.GridModel.createOneGrid;


public class Grid {
    private static final double PER_GRID;
    private static final double MAX_LOSS;

    private static final double CURRENT_PRICE;
    private static final double MAX_GRID_PRICE;


    static {
        //Setting setting = SettingUtil.get("grid.properties");
        PER_GRID = 5;  // 网格大小
        MAX_LOSS = 45; // 最大压力
        CURRENT_PRICE = 1.020; // 当前价格
        MAX_GRID_PRICE = 0.700;
    }

    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.grid();

    }

    public void grid() {
        List<GridModel> gridModels = gen();
        write2Excel(gridModels);
    }


    private List<GridModel> gen() {
        List<GridModel> gridModels = genPricesLteCurrentPrice();
        gridModels.add(genSum(gridModels));
        return gridModels;

    }

    /**
     * 生成大于当前价格的网格
     *
     * @return
     */
    private List<GridModel> genPricesGtCurrentPrice() {
        List<GridModel> gridModels = new ArrayList<>();
        double nextBuyPrice;
        int level = 1;
        do {
            double gridBuyLevel = 1.0 + PER_GRID * level / 100;
            double gridSellLevel = 1.0 + PER_GRID * (level + 1) / 100;
            nextBuyPrice = CURRENT_PRICE * gridBuyLevel;
            double nextSellPrice = CURRENT_PRICE * gridSellLevel;
            level++;
            gridModels.add(createOneGrid(nextBuyPrice, nextSellPrice, gridBuyLevel));
        } while (nextBuyPrice < MAX_GRID_PRICE);
        gridModels.sort(Comparator.comparingDouble(GridModel::getLevel).reversed());
        return gridModels;
    }

    /**
     * 生成小于等于当前价格的网格
     *
     * @return
     */
    private List<GridModel> genPricesLteCurrentPrice() {
        List<GridModel> gridModels = new ArrayList<>();
        int grids = (int) (MAX_LOSS / PER_GRID);
        for (int i = 0; i < grids; i++) {
            double gridBuyLevel = 1.0 - PER_GRID * i / 100;
            double gridSellLevel = 1.0 - PER_GRID * (i - 1) / 100;
            double buyPrice = CURRENT_PRICE * gridBuyLevel;
            double sellPrice = CURRENT_PRICE * gridSellLevel;
            gridModels.add(createOneGrid(buyPrice, sellPrice, gridBuyLevel));
        }
        return gridModels;
    }

    /**
     * 生成合计栏
     *
     * @param gridModels
     * @return
     */
    private GridModel genSum(List<GridModel> gridModels) {
        GridModel gridModel = new GridModel();
        gridModel.setBuyNum(gridModels.stream().mapToDouble(GridModel::getBuyNum).sum());
        gridModel.setBuyPriceSum(gridModels.stream().mapToDouble(GridModel::getBuyPriceSum).sum());
        gridModel.setSellNum(gridModels.stream().mapToInt(GridModel::getSellNum).sum());
        gridModel.setSellPriceSum(gridModels.stream().mapToDouble(GridModel::getSellPriceSum).sum());
        gridModel.setProfit(gridModels.stream().mapToDouble(GridModel::getProfit).sum());
        gridModel.setProfitPercentage(gridModel.getProfit() / gridModel.getBuyPriceSum() * 100);
        return gridModel;
    }


    private void write2Excel(List<GridModel> gridModels) {

        PrettyTable pt = PrettyTable
                .fieldNames("base", "price", "quantity", "amount",
                        "salePrice", "saleQuantity", "saleAmount");

        for (GridModel model : gridModels) {
            pt.addRow(model.getLevel(),
                    new BigDecimal(model.getBuyPrice()).setScale(3, RoundingMode.HALF_DOWN),
                    model.getBuyNum(),
                    new BigDecimal(model.getBuyPriceSum()).setScale(2, RoundingMode.HALF_DOWN),
                    new BigDecimal(model.getSellPrice()).setScale(3, RoundingMode.HALF_DOWN),
                    model.getSellNum(),
                    new BigDecimal(model.getSellPriceSum()).setScale(2, RoundingMode.HALF_DOWN)).comma(true);
                    //model.getLeftNum(),
                    //model.getLeftProfitSellPrice(),
                    //new BigDecimal(model.getProfit()).setScale(2, RoundingMode.HALF_DOWN),
                    //new BigDecimal(model.getProfitPercentage()).setScale(2, RoundingMode.HALF_DOWN)).comma(true);
        }

        System.out.println(pt);
    }

}


