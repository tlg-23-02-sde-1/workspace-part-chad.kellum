package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import com.entertainment.*;
import static org.junit.Assert.*;


public class TelevisionChannelComparatorTest {


    private Television tv;
    private Television tv2;

    @Before
    public void setUp() {
        tv = new Television("Sony", 0,DisplayType.LED);
        tv2 = new Television("Sony", 0, DisplayType.LED);
    }


    @Test
    public void compare_shouldEqualZero_sameChannel() {
        TelevisionChannelComparator compares = new TelevisionChannelComparator();
        assertEquals(0, compares.compare(tv,tv2));
    }

    @Test
    public void compare_shouldNegative_tvLessThanTv2() {
        TelevisionChannelComparator compares = new TelevisionChannelComparator();

    }
}