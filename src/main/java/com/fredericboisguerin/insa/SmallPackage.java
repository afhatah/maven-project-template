package com.fredericboisguerin.insa;

public class SmallPackage extends Package {

    public SmallPackage(int height, int width, int depth, double weight) {
        super(height, width, depth, weight);
    }

    public double calculateLocalShippingCost() {
        double dimension = (double) (height*width*depth);
        return 12d;
    }

}
