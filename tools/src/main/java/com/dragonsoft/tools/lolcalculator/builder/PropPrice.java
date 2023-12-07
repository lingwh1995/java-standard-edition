package com.dragonsoft.tools.lolcalculator.builder;

public class PropPrice {
    /**
     * 皮肤价格
     */
    private String skinPrice;

    /**
     * 云顶之弈价格
     */
    private String tftPrice;

    /**
     * 海克斯道具(海克斯宝箱/杰作宝箱/法球)价格
     */
    private String hextechPropPrice;

    /**
     * 其他道具价格: 头像/符文页/守卫造型/英雄
     */
    private String otherPropPrice;


    public String getSkinPrice() {
        return skinPrice;
    }

    public void setSkinPrice(String skinPrice) {
        this.skinPrice = skinPrice;
    }

    public String getTftPrice() {
        return tftPrice;
    }

    public void setTftPrice(String tftPrice) {
        this.tftPrice = tftPrice;
    }

    public String getHextechPropPrice() {
        return hextechPropPrice;
    }

    public void setHextechPropPrice(String hextechPropPrice) {
        this.hextechPropPrice = hextechPropPrice;
    }

    public String getOtherPropPrice() {
        return otherPropPrice;
    }

    public void setOtherPropPrice(String otherPropPrice) {
        this.otherPropPrice = otherPropPrice;
    }

    public void showPrice() {
        System.out.println(skinPrice);
        System.out.println(tftPrice);
        System.out.println(hextechPropPrice);
        System.out.println(otherPropPrice);
    }
}
