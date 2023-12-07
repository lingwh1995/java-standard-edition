package com.dragonsoft.tools.lolcalculator.builder;


public class PropPriceDirector {
    private AbstractPropPriceBuilder propPriceBuilder;
    public PropPriceDirector(AbstractPropPriceBuilder propPriceBuilder) {
        this.propPriceBuilder = propPriceBuilder;
    }

    public void setPropPriceBuilder(AbstractPropPriceBuilder propPriceBuilder) {
        this.propPriceBuilder = propPriceBuilder;
    }

    public PropPrice build(String mode) {
        propPriceBuilder.buildSkinPrice(mode);
        propPriceBuilder.buildTftPrice(mode);
        propPriceBuilder.buildHextechPropPrice(mode);
        propPriceBuilder.buildOtherPropPrice(mode);
        return propPriceBuilder.buildPropPrice();
    }
}
