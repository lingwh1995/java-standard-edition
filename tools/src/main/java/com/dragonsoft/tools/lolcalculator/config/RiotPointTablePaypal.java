package com.dragonsoft.tools.lolcalculator.config;

public enum RiotPointTablePaypal {
    /**
     * 日服
     */
    NUMBER_OF_RIOTPOINT_CHEAPEST_JP(15000),
    PRICE_OF_RIOTPOINT_CHEAPEST_JP(720),
    NUMBER_OF_RIOTPOINT_EXPENSIVE_JP(525),
    PRICE_OF_RIOTPOINT_EXPENSIVE_JP(30);

    private double numberAndPriceOfRiotPoint;
    RiotPointTablePaypal(double numberAndPriceOfRiotPoint){
        this.numberAndPriceOfRiotPoint = numberAndPriceOfRiotPoint;
    }
    public int getIntValue(){
        return (int)numberAndPriceOfRiotPoint;
    }
    public double getDoubleValue(){
        return numberAndPriceOfRiotPoint;
    }
}
