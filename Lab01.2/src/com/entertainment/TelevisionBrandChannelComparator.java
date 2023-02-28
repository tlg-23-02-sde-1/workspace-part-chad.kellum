package com.entertainment;

import java.util.Comparator;

public class TelevisionBrandChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television tv1, Television tv2) {
        int result = CharSequence.compare(tv1.getBrand(), tv2.getBrand());

        if (result == 0) {
            result = Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
        }
        return result;
    }
}