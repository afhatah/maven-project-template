package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShippingCostsCalculator {

    public double calculateShippingCost(Packagef p, Destination destination){

        switch(destination) {
            case MC:
                return new BigDecimal(p.calculateLocalShippingCost().doubleValue() * 1.087d).setScale(2, RoundingMode.HALF_UP).doubleValue();
            default:
                return new BigDecimal(p.calculateLocalShippingCost().doubleValue()).setScale(2,RoundingMode.HALF_UP).doubleValue();
        }
    }
}
