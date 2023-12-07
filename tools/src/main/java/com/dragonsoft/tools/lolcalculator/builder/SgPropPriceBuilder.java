package com.dragonsoft.tools.lolcalculator.builder;

import com.dragonsoft.tools.lolcalculator.factory.RiotPointPrice;
import com.dragonsoft.tools.lolcalculator.factory.RiotPointPriceFactory;

import java.util.ArrayList;

public class SgPropPriceBuilder extends AbstractPropPriceBuilder {
    private static final String TARGET_REGION_CODE = "SG";
    private static final String TARGET_REGION_NAME = "SG服";
    private static final String COST_REGION_CODE = "VNM";
    private static final Double DISCOUNT_POINT = 1.0;

    private static ArrayList<Double> getPriceList(String priceInfoSource) {
        RiotPointPrice riotPointPrice = RiotPointPriceFactory.getRiotPointPrice(priceInfoSource,TARGET_REGION_CODE);
        ArrayList<Double> priceList = new ArrayList<>();
        //获得每1RP淘宝/Paypal中最便宜的价格
        double cheapestRiotPointPrice = riotPointPrice.getPriceOfRiotPointCheapest() / riotPointPrice.getNumberOfRiotPointCheapest();
        //获得每1RP淘宝/Palpal中最贵的价格
        double expensiveRiotPointPrice = riotPointPrice.getPriceOfRiotPointExpensive() / riotPointPrice.getNumberOfRiotPointExpensive();

        //重置引用
        riotPointPrice = RiotPointPriceFactory.getRiotPointPrice(priceInfoSource,COST_REGION_CODE);
        //获得每1RP越南服最便宜的价格
        double vietnamCheapestRiotPointPrice = riotPointPrice.getPriceOfRiotPointCheapest() / riotPointPrice.getNumberOfRiotPointCheapest();
        //获得每1RP越南服最便宜的价格
        double vietnamExpensiveRiotPointPrice = riotPointPrice.getPriceOfRiotPointExpensive() / riotPointPrice.getNumberOfRiotPointExpensive();
        priceList.add(cheapestRiotPointPrice);
        priceList.add(expensiveRiotPointPrice);
        priceList.add(vietnamCheapestRiotPointPrice);
        priceList.add(vietnamExpensiveRiotPointPrice);
        //建议售价
        double suggestSalePrice = (cheapestRiotPointPrice + vietnamCheapestRiotPointPrice) /2 * DISCOUNT_POINT;
        priceList.add(suggestSalePrice);
        //可赚取利润
        priceList.add(suggestSalePrice - vietnamCheapestRiotPointPrice);
        return priceList;
    }

    @Override
    public void buildSkinPrice(String priceInfoSource) {
        StringBuilder riotPointPricestringBuilder = new StringBuilder();
        ArrayList<Double> priceList = getPriceList(priceInfoSource);
        String tenRiotPointSuggestSalePrice = String.format("%.2f",priceList.get(4) * 10);
        //拼接表头
        riotPointPricestringBuilder.append(TARGET_REGION_NAME + "皮肤价格表(10RP建议零售价:" + tenRiotPointSuggestSalePrice + ")\n");
        riotPointPricestringBuilder.append("-----------------------------------------------------------------------------------------------------------------------------\n");
        riotPointPricestringBuilder.append("|\tRP等级\t\t");
        riotPointPricestringBuilder.append("|\t390RP\t");
        riotPointPricestringBuilder.append("|\t490RP\t");
        riotPointPricestringBuilder.append("|\t520RP\t");
        riotPointPricestringBuilder.append("|\t750RP\t");
        riotPointPricestringBuilder.append("|\t790RP\t");
        riotPointPricestringBuilder.append("|\t975RP\t");
        riotPointPricestringBuilder.append("|\t1350RP\t");
        riotPointPricestringBuilder.append("|\t1820RP\t");
        riotPointPricestringBuilder.append("|\t3250RP\t|\n");

        for(int i=0; i<priceList.size(); i++) {
            switch (i) {
                case 0:
                    riotPointPricestringBuilder.append("|\t最便宜价格\t");
                    break;
                case 1:
                    riotPointPricestringBuilder.append("|\t最昂贵价格\t");
                    break;
                case 2:
                    riotPointPricestringBuilder.append("|\t最低成本价\t");
                    break;
                case 3:
                    riotPointPricestringBuilder.append("|\t最高成本价\t");
                    break;
                case 4:
                    riotPointPricestringBuilder.append("|\t建议零售价\t");
                    break;
                case 5:
                    riotPointPricestringBuilder.append("|\t可赚取利润\t");
                    break;
                default:
                    break;
            }
            Double price = priceList.get(i);
            //390RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 390));
            riotPointPricestringBuilder.append("\t");

            //490RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 490));
            riotPointPricestringBuilder.append("\t");

            //520RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 520));
            riotPointPricestringBuilder.append("\t");

            //750RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 750));
            riotPointPricestringBuilder.append("\t");

            //790RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 790));
            riotPointPricestringBuilder.append("\t");

            //975RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 975));
            riotPointPricestringBuilder.append("\t");

            //1350RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 1350));
            riotPointPricestringBuilder.append("\t");

            //1820RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 1820));
            riotPointPricestringBuilder.append("\t");

            //3250RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 3250));
            riotPointPricestringBuilder.append("\t|\n");
        }
        riotPointPricestringBuilder.append("-----------------------------------------------------------------------------------------------------------------------------\n");
        super.propPrice.setSkinPrice(riotPointPricestringBuilder.toString());
    }

    @Override
    public void buildTftPrice(String priceInfoSource) {
        StringBuilder riotPointPricestringBuilder = new StringBuilder();
        ArrayList<Double> priceList = getPriceList(priceInfoSource);
        String tenRiotPointSuggestSalePrice = String.format("%.2f",priceList.get(4) * 10);
        //拼接表头
        riotPointPricestringBuilder.append(TARGET_REGION_NAME + "TFT价格表(10RP建议零售价:" + tenRiotPointSuggestSalePrice + ")\n");
        riotPointPricestringBuilder.append("-----------------------------------------------------------------------------------------\n");
        riotPointPricestringBuilder.append("|\tRP等级\t\t");
        riotPointPricestringBuilder.append("|\t390RP\t");
        riotPointPricestringBuilder.append("|\t490RP\t");
        riotPointPricestringBuilder.append("|\t1950RP\t");
        riotPointPricestringBuilder.append("|\t2450RP\t");
        riotPointPricestringBuilder.append("|\t3900RP\t");
        riotPointPricestringBuilder.append("|\t4900RP\t|\n");

        for(int i=0; i<priceList.size(); i++) {
            switch (i) {
                case 0:
                    riotPointPricestringBuilder.append("|\t最便宜价格\t");
                    break;
                case 1:
                    riotPointPricestringBuilder.append("|\t最昂贵价格\t");
                    break;
                case 2:
                    riotPointPricestringBuilder.append("|\t最低成本价\t");
                    break;
                case 3:
                    riotPointPricestringBuilder.append("|\t最高成本价\t");
                    break;
                case 4:
                    riotPointPricestringBuilder.append("|\t建议零售价\t");
                    break;
                case 5:
                    riotPointPricestringBuilder.append("|\t可赚取利润\t");
                    break;
                default:
                    break;
            }
            Double price = priceList.get(i);
            //390RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 390));
            riotPointPricestringBuilder.append("\t");

            //490RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 490));
            riotPointPricestringBuilder.append("\t");

            //1950RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 1950));
            riotPointPricestringBuilder.append("\t");

            //2450RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 2450));
            riotPointPricestringBuilder.append("\t");

            //3900RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 3900));
            riotPointPricestringBuilder.append("\t");

            //4900RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 4900));
            riotPointPricestringBuilder.append("\t|\n");
        }
        riotPointPricestringBuilder.append("-----------------------------------------------------------------------------------------\n");
        super.propPrice.setTftPrice(riotPointPricestringBuilder.toString());
    }

    @Override
    public void buildHextechPropPrice(String priceInfoSource) {
        StringBuilder riotPointPricestringBuilder = new StringBuilder();
        ArrayList<Double> priceList = getPriceList(priceInfoSource);
        String tenRiotPointSuggestSalePrice = String.format("%.2f",priceList.get(4) * 10);
        //拼接表头
        riotPointPricestringBuilder.append(TARGET_REGION_NAME + "海克斯道具价格表(10RP建议零售价:" + tenRiotPointSuggestSalePrice + ")\n");
        riotPointPricestringBuilder.append("------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        riotPointPricestringBuilder.append("|\tDLC\t\t\t");
        riotPointPricestringBuilder.append("|\t蓝箱子*1\t");
        riotPointPricestringBuilder.append("|\tDLC5\t");
        riotPointPricestringBuilder.append("|\tDLC6\t");
        riotPointPricestringBuilder.append("|\tDLC7\t");
        riotPointPricestringBuilder.append("|\t杰作*1\t");
        riotPointPricestringBuilder.append("|\tDLC8\t");
        riotPointPricestringBuilder.append("|\tDLC9\t");
        riotPointPricestringBuilder.append("|\tDLC10\t");
        riotPointPricestringBuilder.append("|\t法球*1\t");
        riotPointPricestringBuilder.append("|\tDLC11\t");
        riotPointPricestringBuilder.append("|\t1DLC12\t");
        riotPointPricestringBuilder.append("|\tDLC13\t");
        riotPointPricestringBuilder.append("|\tDLC14\t|\n");

        riotPointPricestringBuilder.append("|\tRP等级\t\t");
        riotPointPricestringBuilder.append("|\t195RP\t");
        riotPointPricestringBuilder.append("|\t1950RP\t");
        riotPointPricestringBuilder.append("|\t3900RP\t");
        riotPointPricestringBuilder.append("|\t9750RP\t");
        riotPointPricestringBuilder.append("|\t225RP\t");
        riotPointPricestringBuilder.append("|\t2250RP\t");
        riotPointPricestringBuilder.append("|\t5625RP\t");
        riotPointPricestringBuilder.append("|\t11250RP\t");
        riotPointPricestringBuilder.append("|\t250RP\t");
        riotPointPricestringBuilder.append("|\t2500RP\t");
        riotPointPricestringBuilder.append("|\t12500RP\t");
        riotPointPricestringBuilder.append("|\t6250RP\t");
        riotPointPricestringBuilder.append("|\t12500RP\t|\n");

        for(int i=0; i<priceList.size(); i++) {
            switch (i) {
                case 0:
                    riotPointPricestringBuilder.append("|\t最便宜价格\t");
                    break;
                case 1:
                    riotPointPricestringBuilder.append("|\t最昂贵价格\t");
                    break;
                case 2:
                    riotPointPricestringBuilder.append("|\t最低成本价\t");
                    break;
                case 3:
                    riotPointPricestringBuilder.append("|\t最高成本价\t");
                    break;
                case 4:
                    riotPointPricestringBuilder.append("|\t建议零售价\t");
                    break;
                case 5:
                    riotPointPricestringBuilder.append("|\t可赚取利润\t");
                    break;
                default:
                    break;
            }
            Double price = priceList.get(i);
            //195RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 195));
            riotPointPricestringBuilder.append("\t");

            //1950RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 1950));
            riotPointPricestringBuilder.append("\t");

            //3900RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 3900));
            riotPointPricestringBuilder.append("\t");

            //9750RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 9750));
            riotPointPricestringBuilder.append("\t");

            //225RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 225));
            riotPointPricestringBuilder.append("\t");

            //2250RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 2250));
            riotPointPricestringBuilder.append("\t");

            //5625RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 5625));
            riotPointPricestringBuilder.append("\t");

            //11250RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 11250));
            riotPointPricestringBuilder.append("\t");

            //250RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 250));
            riotPointPricestringBuilder.append("\t");

            //2500RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 2500));
            riotPointPricestringBuilder.append("\t");

            //12500RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 12500));
            riotPointPricestringBuilder.append("\t");

            //6250RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 6250));
            riotPointPricestringBuilder.append("\t");

            //12500RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 12500));
            riotPointPricestringBuilder.append("\t|\n");
        }
        riotPointPricestringBuilder.append("------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        super.propPrice.setHextechPropPrice(riotPointPricestringBuilder.toString());
    }

    @Override
    public void buildOtherPropPrice(String priceInfoSource) {
        StringBuilder riotPointPricestringBuilder = new StringBuilder();
        ArrayList<Double> priceList = getPriceList(priceInfoSource);
        String tenRiotPointSuggestSalePrice = String.format("%.2f",priceList.get(4) * 10);

        //拼接表头
        riotPointPricestringBuilder.append(TARGET_REGION_NAME + "头像/符文页/守卫造型/英雄价格表(10RP建议零售价:" + tenRiotPointSuggestSalePrice + ")\n");
        riotPointPricestringBuilder.append("-----------------------------------------------------------------------------------------------------\n");
        riotPointPricestringBuilder.append("|\tRP等级\t\t");
        riotPointPricestringBuilder.append("|\t250RP\t");
        riotPointPricestringBuilder.append("|\t590RP\t");
        riotPointPricestringBuilder.append("|\t640RP\t");
        riotPointPricestringBuilder.append("|\t585RP\t");
        riotPointPricestringBuilder.append("|\t790RP\t");
        riotPointPricestringBuilder.append("|\t880RP\t");
        riotPointPricestringBuilder.append("|\t975RP\t|\n");

        for(int i=0; i<priceList.size(); i++) {
            switch (i) {
                case 0:
                    riotPointPricestringBuilder.append("|\t最便宜价格\t");
                    break;
                case 1:
                    riotPointPricestringBuilder.append("|\t最昂贵价格\t");
                    break;
                case 2:
                    riotPointPricestringBuilder.append("|\t最低成本价\t");
                    break;
                case 3:
                    riotPointPricestringBuilder.append("|\t最高成本价\t");
                    break;
                case 4:
                    riotPointPricestringBuilder.append("|\t建议零售价\t");
                    break;
                case 5:
                    riotPointPricestringBuilder.append("|\t可赚取利润\t");
                    break;
                default:
                    break;
            }
            Double price = priceList.get(i);
            //250RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 250));
            riotPointPricestringBuilder.append("\t");

            //590RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 590));
            riotPointPricestringBuilder.append("\t");

            //640RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 640));
            riotPointPricestringBuilder.append("\t");

            //585RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 585));
            riotPointPricestringBuilder.append("\t");

            //790RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 790));
            riotPointPricestringBuilder.append("\t");

            //880RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 880));
            riotPointPricestringBuilder.append("\t");

            //975RP
            riotPointPricestringBuilder.append("|\t");
            riotPointPricestringBuilder.append(String.format("%.2f",price * 975));
            riotPointPricestringBuilder.append("\t|\n");
        }
        riotPointPricestringBuilder.append("-----------------------------------------------------------------------------------------------------\n");
        super.propPrice.setOtherPropPrice(riotPointPricestringBuilder.toString());
    }
}
