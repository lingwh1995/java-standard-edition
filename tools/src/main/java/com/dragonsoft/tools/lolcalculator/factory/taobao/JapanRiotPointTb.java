package com.dragonsoft.tools.lolcalculator.factory.taobao;

import com.dragonsoft.tools.lolcalculator.config.RiotPointTableTb;
import com.dragonsoft.tools.lolcalculator.factory.RiotPointPrice;

public class JapanRiotPointTb extends RiotPointPrice {
    public JapanRiotPointTb(int numberOfRiotPointCheapest, double priceOfRiotPointCheapest,
                            int numberOfRiotPointExpensive, double priceOfRiotPointExpensive) {
        super(numberOfRiotPointCheapest, priceOfRiotPointCheapest, numberOfRiotPointExpensive, priceOfRiotPointExpensive);
    }

    public JapanRiotPointTb() {
        super(RiotPointTableTb.NUMBER_OF_RIOTPOINT_CHEAPEST_JP.getIntValue(),
                RiotPointTableTb.PRICE_OF_RIOTPOINT_CHEAPEST_JP.getDoubleValue(),
                RiotPointTableTb.NUMBER_OF_RIOTPOINT_EXPENSIVE_JP.getIntValue(),
                RiotPointTableTb.PRICE_OF_RIOTPOINT_EXPENSIVE_JP.getDoubleValue());
    }

}
