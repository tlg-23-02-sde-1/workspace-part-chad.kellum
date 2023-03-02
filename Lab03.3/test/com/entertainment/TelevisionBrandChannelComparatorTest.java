package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {

    private Television tvA;
    private Television tvB;
    @Before
    public void setUp() {
        tvA = new Television("Sony", 50);
        tvB = new Television("Sony", 50);
    }

    @Test
    public void compare_shouldReturnNegative_AisLessThanB() {

        int result = tvA.compareTo(tvB);
        assertEquals("Expected to be less that", result <= -1);



    }
}