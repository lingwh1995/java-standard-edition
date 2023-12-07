package com.dragonsoft.tools.lolcalculator.config;

public enum RiotPointTableTb {
    /**
     * 越南服
     */
    NUMBER_OF_RIOTPOINT_CHEAPEST_VNM(11325),
    PRICE_OF_RIOTPOINT_CHEAPEST_VNM(275),
    NUMBER_OF_RIOTPOINT_EXPENSIVE_VNM(195),
    PRICE_OF_RIOTPOINT_EXPENSIVE_VNM(6.4),

    /**
     * 日服
     */
    NUMBER_OF_RIOTPOINT_CHEAPEST_JP(15000),
    PRICE_OF_RIOTPOINT_CHEAPEST_JP(720),
    NUMBER_OF_RIOTPOINT_EXPENSIVE_JP(525),
    PRICE_OF_RIOTPOINT_EXPENSIVE_JP(30),

    /**
     * 新加坡、马来西亚、印度尼西亚
     */
    NUMBER_OF_RIOTPOINT_CHEAPEST_SG(10250),
    PRICE_OF_RIOTPOINT_CHEAPEST_SG(375),
    NUMBER_OF_RIOTPOINT_EXPENSIVE_SG(525),
    PRICE_OF_RIOTPOINT_EXPENSIVE_SG(30),

    /**
     * 台服
     */
    NUMBER_OF_RIOTPOINT_CHEAPEST_TW(13000),
    PRICE_OF_RIOTPOINT_CHEAPEST_TW(404),
    NUMBER_OF_RIOTPOINT_EXPENSIVE_TW(515),
    PRICE_OF_RIOTPOINT_EXPENSIVE_TW(18.7);
    private double numberAndPriceOfRiotPoint;
    RiotPointTableTb(double numberAndPriceOfRiotPoint){
        this.numberAndPriceOfRiotPoint = numberAndPriceOfRiotPoint;
    }
    public int getIntValue(){
        return (int)numberAndPriceOfRiotPoint;
    }
    public double getDoubleValue(){
        return numberAndPriceOfRiotPoint;
    }
}
