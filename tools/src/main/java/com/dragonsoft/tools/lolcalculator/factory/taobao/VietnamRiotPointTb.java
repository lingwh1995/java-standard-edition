package com.dragonsoft.tools.lolcalculator.factory.taobao;

import com.dragonsoft.tools.lolcalculator.config.RiotPointTableTb;
import com.dragonsoft.tools.lolcalculator.factory.RiotPointPrice;

public class VietnamRiotPointTb extends RiotPointPrice {
    public VietnamRiotPointTb(int numberOfRiotPointCheapest, double priceOfRiotPointCheapest,
                              int numberOfRiotPointExpensive, double priceOfRiotPointExpensive) {
        super(numberOfRiotPointCheapest, priceOfRiotPointCheapest, numberOfRiotPointExpensive, priceOfRiotPointExpensive);
    }

    public VietnamRiotPointTb() {
        super(RiotPointTableTb.NUMBER_OF_RIOTPOINT_CHEAPEST_VNM.getIntValue(),
                RiotPointTableTb.PRICE_OF_RIOTPOINT_CHEAPEST_VNM.getDoubleValue(),
                RiotPointTableTb.NUMBER_OF_RIOTPOINT_EXPENSIVE_VNM.getIntValue(),
                RiotPointTableTb.PRICE_OF_RIOTPOINT_EXPENSIVE_VNM.getDoubleValue());
    }

}
