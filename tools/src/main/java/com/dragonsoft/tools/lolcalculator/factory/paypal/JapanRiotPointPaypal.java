package com.dragonsoft.tools.lolcalculator.factory.paypal;

import com.dragonsoft.tools.lolcalculator.config.RiotPointTablePaypal;
import com.dragonsoft.tools.lolcalculator.factory.RiotPointPrice;

public class JapanRiotPointPaypal extends RiotPointPrice {
    public JapanRiotPointPaypal(int numberOfRiotPointCheapest, double priceOfRiotPointCheapest,
                                int numberOfRiotPointExpensive, double priceOfRiotPointExpensive) {
        super(numberOfRiotPointCheapest, priceOfRiotPointCheapest, numberOfRiotPointExpensive, priceOfRiotPointExpensive);
    }

    public JapanRiotPointPaypal() {
        super(RiotPointTablePaypal.NUMBER_OF_RIOTPOINT_CHEAPEST_JP.getIntValue(),
                RiotPointTablePaypal.PRICE_OF_RIOTPOINT_CHEAPEST_JP.getDoubleValue(),
                RiotPointTablePaypal.NUMBER_OF_RIOTPOINT_EXPENSIVE_JP.getIntValue(),
                RiotPointTablePaypal.PRICE_OF_RIOTPOINT_EXPENSIVE_JP.getDoubleValue());
    }

}
