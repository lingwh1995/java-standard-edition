package com.dragonsoft.tools.lolcalculator;

import com.dragonsoft.tools.lolcalculator.builder.*;

public class Client {
    public static void main(String[] args) {
        System.out.println(18.21*2 + 23.68*3 + 32.78);
        //日服价格表
        AbstractPropPriceBuilder concretePriceBuilder = new JapanPropPriceBuilder();
        PropPriceDirector propPriceDirector = new PropPriceDirector(concretePriceBuilder);
        PropPrice japanPropPrice = propPriceDirector.build("TB");
        japanPropPrice.showPrice();
        System.out.println("===============================================");


        //SG服价格表
        concretePriceBuilder = new SgPropPriceBuilder();
        propPriceDirector = new PropPriceDirector(concretePriceBuilder);
        PropPrice sgPropPrice = propPriceDirector.build("TB");
        sgPropPrice.showPrice();
        System.out.println("===============================================");


        //台服价格表
        concretePriceBuilder = new TaiwanPropPriceBuilder();
        propPriceDirector = new PropPriceDirector(concretePriceBuilder);
        PropPrice taiWanPropPrice = propPriceDirector.build("TB");
        taiWanPropPrice.showPrice();
    }

}
