package com.fredericboisguerin.insa;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UITest {

    private Package mockedPackage;
    private PackageFactory mockedPackageFactory;
    private ShippingCostsCalculator mockedCalc;

    @Before
    public void setUp() {
        mockedPackageFactory = mock(PackageFactory.class);
        mockedCalc = mock(ShippingCostsCalculator.class);
    }

    @Test
    public void create_small_package() {
        String input = "191\n123\n18\n2.354\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UI.askForNewPackage(mockedPackageFactory);
        verify(mockedPackageFactory).createPackage(191,123,18,2.354);
    }

    @Test
    public void calculate_small_package_france() {
        Package p = (new PackageFactory()).createPackage(191,123,18,2.354);

        String input = "FR\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UI.askForShippingCost(mockedCalc, p);
        verify(mockedCalc).calculateShippingCost(p, Destination.FR);
    }

}
