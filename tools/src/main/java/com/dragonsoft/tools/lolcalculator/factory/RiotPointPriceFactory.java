package com.dragonsoft.tools.lolcalculator.factory;

import com.dragonsoft.tools.lolcalculator.factory.taobao.JapanRiotPointTb;
import com.dragonsoft.tools.lolcalculator.factory.taobao.SgRiotPointTb;
import com.dragonsoft.tools.lolcalculator.factory.taobao.TaiwanRiotPointTb;
import com.dragonsoft.tools.lolcalculator.factory.taobao.VietnamRiotPointTb;

public class RiotPointPriceFactory {
    /**
     * 通过工厂方法生产产品
     * priceInfoSource 价格信息来源,TB或者PAYPAL
     * @param region 地区
     * @return
     */
    private static RiotPointPrice factoryMethod(String priceInfoSource, String region) {
        RiotPointPrice product = null;
        if(priceInfoSource.equals("TB")) {
            switch (region) {
                case "JP":
                    product = new JapanRiotPointTb();
                    break;
                case "VNM":
                    product = new VietnamRiotPointTb();
                    break;
                case "SG":
                    product = new SgRiotPointTb();
                    break;
                case "TW":
                    product = new TaiwanRiotPointTb();
                    break;
                default:
                    break;
            }
        }else if(priceInfoSource.equals("PAYPAL")) {

        }
        return product;
    }

    /**
     * 调用工厂方法的方法
     * priceInfoSource 价格信息来源,TB或者PAYPAL
     * @param region 地区
     */
    public static RiotPointPrice getRiotPointPrice(String priceInfoSource, String region){
        return factoryMethod(priceInfoSource,region);
    }
}
