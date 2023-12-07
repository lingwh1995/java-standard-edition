package com.dragonsoft.tools.lolcalculator.factory.taobao;

import com.dragonsoft.tools.lolcalculator.config.RiotPointTableTb;
import com.dragonsoft.tools.lolcalculator.factory.RiotPointPrice;

public class TaiwanRiotPointTb extends RiotPointPrice {
    public TaiwanRiotPointTb(int numberOfRiotPointCheapest, double priceOfRiotPointCheapest,
                         int numberOfRiotPointExpensive, double priceOfRiotPointExpensive) {
        super(numberOfRiotPointCheapest, priceOfRiotPointCheapest, numberOfRiotPointExpensive, priceOfRiotPointExpensive);
    }

    public TaiwanRiotPointTb() {
        super(RiotPointTableTb.NUMBER_OF_RIOTPOINT_CHEAPEST_TW.getIntValue(),
                RiotPointTableTb.PRICE_OF_RIOTPOINT_CHEAPEST_TW.getDoubleValue(),
                RiotPointTableTb.NUMBER_OF_RIOTPOINT_EXPENSIVE_TW.getIntValue(),
                RiotPointTableTb.PRICE_OF_RIOTPOINT_EXPENSIVE_TW.getDoubleValue());
    }
}
