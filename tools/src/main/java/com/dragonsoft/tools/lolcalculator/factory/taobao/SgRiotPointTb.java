package com.dragonsoft.tools.lolcalculator.factory.taobao;

import com.dragonsoft.tools.lolcalculator.config.RiotPointTableTb;
import com.dragonsoft.tools.lolcalculator.factory.RiotPointPrice;

public class SgRiotPointTb extends RiotPointPrice {
    public SgRiotPointTb(int numberOfRiotPointCheapest, double priceOfRiotPointCheapest,
                              int numberOfRiotPointExpensive, double priceOfRiotPointExpensive) {
        super(numberOfRiotPointCheapest, priceOfRiotPointCheapest, numberOfRiotPointExpensive, priceOfRiotPointExpensive);
    }

    public SgRiotPointTb() {
        super(RiotPointTableTb.NUMBER_OF_RIOTPOINT_CHEAPEST_SG.getIntValue(),
                RiotPointTableTb.PRICE_OF_RIOTPOINT_CHEAPEST_SG.getDoubleValue(),
                RiotPointTableTb.NUMBER_OF_RIOTPOINT_EXPENSIVE_SG.getIntValue(),
                RiotPointTableTb.PRICE_OF_RIOTPOINT_EXPENSIVE_SG.getDoubleValue());
    }
}
