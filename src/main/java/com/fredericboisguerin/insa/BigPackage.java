package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigPackage extends Package {

    public BigPackage(int height, int width, int depth, double weight) {
        super(height, width, depth, weight);
    }

    public double calculateLocalShippingCost() {
        double dimension = (double) (height*width*depth);
        return new BigDecimal(Math.max(weight * COEFF_WEIGHT_OVER_WEIGHT_AND_DIMENSION,((dimension/Math.pow(10,6))* COEFF_BY_DIMENSION_OVER_WEIGHT_AND_DIMENSION))).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

}
