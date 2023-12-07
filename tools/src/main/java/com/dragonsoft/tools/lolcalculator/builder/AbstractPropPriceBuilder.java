package com.dragonsoft.tools.lolcalculator.builder;

public abstract class AbstractPropPriceBuilder {

    protected PropPrice propPrice = new PropPrice();

    //皮肤价格
    public abstract void buildSkinPrice(String mode);
    //tft价格
    public abstract void buildTftPrice(String mode);
    //海克斯道具价格
    public abstract void buildHextechPropPrice(String mode);
    //其他道具价格
    public abstract void buildOtherPropPrice(String priceInfoSource);

    //建造好房子后，返回房子
    public PropPrice buildPropPrice(){
        return propPrice;
    }
}
