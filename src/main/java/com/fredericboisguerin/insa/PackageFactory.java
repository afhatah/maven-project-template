package com.fredericboisguerin.insa;


public class PackageFactory {

    public static Package createPackage(int height, int width, int depth, double weight) {
        double dimension = (double) (height*width*depth);

        if (dimension <= Package.DIMENSION_REFERENCE) {
            return new SmallPackage(height, width, depth, weight);
        }
        else if (weight <= Package.WEIGHT_REFERENCE && dimension > Package.DIMENSION_REFERENCE) {
           return new MediumPackage(height, width, depth, weight);
        }
        else {
            return new BigPackage(height, width, depth, weight);
        }
    }

}
