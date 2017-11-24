package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Package {

    public static final double DIMENSION_REFERENCE = 229d * 162 * 25;
    public static final double WEIGHT_REFERENCE = 1.8d;
    public static final double COEFF_WEIGHT_OVER_DIMENSION = 17.59d;
    public static final double EXTRA_FEE_OVER_DIMENSION = 2.86d;
    public static final double COEFF_WEIGHT_OVER_WEIGHT_AND_DIMENSION = 21.62d;
    public static final double COEFF_BY_DIMENSION_OVER_WEIGHT_AND_DIMENSION = 1.43d;
    public int height;
    public int width;
    public int depth;
    public double weight;

    public Package(int height, int width, int depth, double weight){
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.depth = depth;

    }

    public BigDecimal calculateLocalShippingCost(){
        double dimension = (double) (height*width*depth);

        if (dimension <= DIMENSION_REFERENCE)
            return new BigDecimal(12d);

        if (weight <= WEIGHT_REFERENCE && dimension > DIMENSION_REFERENCE)
            return (new BigDecimal(weight* COEFF_WEIGHT_OVER_DIMENSION + EXTRA_FEE_OVER_DIMENSION)).setScale(2, RoundingMode.HALF_UP);

        return new BigDecimal(Math.max(weight * COEFF_WEIGHT_OVER_WEIGHT_AND_DIMENSION,((dimension/Math.pow(10,6))* COEFF_BY_DIMENSION_OVER_WEIGHT_AND_DIMENSION))).setScale(2, RoundingMode.HALF_EVEN);
    }

}
