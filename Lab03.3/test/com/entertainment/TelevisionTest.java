package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {

    private Television tv;
    private Television tv2;

    @Before
    public void setUp() {
        tv = new Television("Sony", 0,DisplayType.LED);
        tv2 = new Television("Sony", 0, DisplayType.LED);
    }



    @Test
    public void hashCode_equalObjects_mustHaveEqualHashCodes() {
        assertEquals(tv.hashCode(), tv2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_DifferentBrands() {
        tv2.setBrand("LG");
        assertNotEquals(tv, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_DifferentVolume() {
        tv2.setVolume(15);
        assertNotEquals(tv, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_DifferentDisplayType() {
        tv2.setDisplay(DisplayType.OLED);
        assertNotEquals(tv, tv2);
    }

    @Test
    public void equals_shouldReturnTrue_AllPropertiesSame() {
        assertEquals(tv, tv2);
    }

    @Test
    public void compareTo_shouldEqualBrandName() {
        assertEquals(tv.getBrand(), tv2.getBrand());
    }

    @Test
    public void compareTo_shouldInvalidBrandName_whenBrandDifferent() {
        tv2.setBrand("Toshiba");
        assertNotEquals(tv.getBrand(), tv2.getBrand());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_upperBound()
    throws InvalidChannelException{
        try {
            tv.changeChannel(1000);
            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
            throw e;
        }
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws InvalidChannelException {
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() {
        try {
            tv.changeChannel(0);
            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e){
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        tv.setVolume(101);
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() { // unchecked
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv.setVolume(-1);
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }
}