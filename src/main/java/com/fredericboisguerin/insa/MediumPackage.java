package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MediumPackage extends Package {

    public MediumPackage(int height, int width, int depth, double weight) {
        super(height, width, depth, weight);
    }

    public double calculateLocalShippingCost() {
        double dimension = (double) (height*width*depth);
        return (new BigDecimal(weight* COEFF_WEIGHT_OVER_DIMENSION + EXTRA_FEE_OVER_DIMENSION)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

}
