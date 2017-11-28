package com.fredericboisguerin.insa;

public abstract class Package {

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

    public abstract double calculateLocalShippingCost();

}
