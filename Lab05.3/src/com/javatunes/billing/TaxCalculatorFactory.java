package com.javatunes.billing;

import com.javatunes.product.Product;

public class TaxCalculatorFactory {

    // prevent instantiation - this is an all static class
    private TaxCalculatorFactory() {

        /*
         * Optional Challenge:
         * Implement a cache of TaxCalculator objects, such that we
         * return a previously created one if one is there, and
         * if not, we create and return a new one.
         *
         * Hint: you can use a Map<Location, TaxCalculator> for the cache
         *
         * Location     |    TaxCalculator
         * make a new one and PUT it in there.
         */

    }
    public static TaxCalculator getTaxCalculator (Location location) {
        TaxCalculator calc = null;

        switch (location) {
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
        }

        return calc;
    }

}