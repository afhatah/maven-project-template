package com.fredericboisguerin.insa;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */

@RunWith(Parameterized.class)
public class PackageTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { 191, 123, 18,  2.354d, "FR", "12.00" },
                { 253, 215, 164, 1.565d, "FR", "30.39" },
                { 653, 133, 271, 2.132d, "FR", "46.09" },
                { 653, 331, 271, 3.650d, "FR", "83.76" },
                { 123, 191, 18,  2.354d, "MC", "13.04" },
                { 253, 215, 164, 1.565d, "MC", "33.03" },
                { 653, 133, 271, 2.132d, "MC", "50.10" },
                { 653, 331, 271, 3.650d, "MC", "91.05" },
                { 191, 123, 18, 2.354d, "DOM/TOM", "13.91" },
                { 253, 215, 164, 1.565d, "DOM/TOM", "33.29" },
                { 653, 133, 271, 2.132d, "DOM/TOM", "49.84" },
                { 653, 331, 271, 3.650d, "DOM/TOM", "89.54" }

        });
    }

    private int height;
    private int width;
    private int depth;
    private double weight;
    private String dest;
    private String expected;

    public PackageTest(int height, int width, int depth, double weight, String dest, String expected) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.dest = dest;
        this.expected = expected;
    }

    @org.junit.Test
    public void test() {
        ShippingCostsCalculator calc = new ShippingCostsCalculator();

        Package p = PackageFactory.createPackage(this.height, this.width, this.depth, this.weight);

        if (this.dest.equals("FR"))
            assertEquals(Double.parseDouble(expected), calc.calculateShippingCost(p,Destination.FR), 0.001d);
        else if (this.dest.equals("DOM/TOM"))
            assertEquals(Double.parseDouble(expected), calc.calculateShippingCost(p,Destination.DOMTOM), 0.001d);
        else
            assertEquals(Double.parseDouble(expected), calc.calculateShippingCost(p,Destination.MC), 0.001d);
    }

}