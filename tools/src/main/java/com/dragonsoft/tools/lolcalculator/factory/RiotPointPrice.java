package com.dragonsoft.tools.lolcalculator.factory;

public abstract class RiotPointPrice {
    /**
     * RiotPoint数量:最便宜的
     */
    private int numberOfRiotPointCheapest;
    /**
     * RiotPoint价格:最便宜的
     */
    private double priceOfRiotPointCheapest;
    /**
     * RiotPoint数量:最贵的
     */
    private int numberOfRiotPointExpensive;
    /**
     * RiotPoint价格:最贵的
     */
    private double priceOfRiotPointExpensive;

    public RiotPointPrice(int numberOfRiotPointCheapest, double priceOfRiotPointCheapest, int numberOfRiotPointExpensive, double priceOfRiotPointExpensive) {
        this.numberOfRiotPointCheapest = numberOfRiotPointCheapest;
        this.priceOfRiotPointCheapest = priceOfRiotPointCheapest;
        this.numberOfRiotPointExpensive = numberOfRiotPointExpensive;
        this.priceOfRiotPointExpensive = priceOfRiotPointExpensive;
    }

    public double getNumberOfRiotPointCheapest() {
        return numberOfRiotPointCheapest;
    }

    public void setNumberOfRiotPointCheapest(int numberOfRiotPointCheapest) {
        this.numberOfRiotPointCheapest = numberOfRiotPointCheapest;
    }

    public double getPriceOfRiotPointCheapest() {
        return priceOfRiotPointCheapest;
    }

    public void setPriceOfRiotPointCheapest(double priceOfRiotPointCheapest) {
        this.priceOfRiotPointCheapest = priceOfRiotPointCheapest;
    }

    public double getNumberOfRiotPointExpensive() {
        return numberOfRiotPointExpensive;
    }

    public void setNumberOfRiotPointExpensive(int numberOfRiotPointExpensive) {
        this.numberOfRiotPointExpensive = numberOfRiotPointExpensive;
    }

    public double getPriceOfRiotPointExpensive() {
        return priceOfRiotPointExpensive;
    }

    public void setPriceOfRiotPointExpensive(double priceOfRiotPointExpensive) {
        this.priceOfRiotPointExpensive = priceOfRiotPointExpensive;
    }
}
