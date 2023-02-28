package com.entertainment;

import java.util.Objects;

public class Television {
    private String brand;
    private int volume;

    private Tuner tuner = new Tuner();

    // Constructors

    public Television() {

    }

    public Television(String brand, int volume) {
        this.brand = brand;
        this.volume = volume;
    }
    // fields

    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    // accessors
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof Television) {
            Television other = (Television) obj;
            result = Objects.equals(this.getBrand(), other.getBrand()) &&  // null-safe check
                     this.getVolume() == other.getVolume(); // int can't be null
        }
        return result;
    }

    public int hashCode(){
        // this is a poorly written hash function because it easily results in "hash collisions"
        // a "hash collision" is when different objects (by equals() have the SAME hashcode by coincidence.
//        return getBrand().length() + getVolume();
        return Objects.hash(getBrand(), getVolume());
    }

    public String toString() {
        return getClass().getSimpleName() + " [brand=" + getBrand() + ", volume=" +
                getVolume() + ", currentChannel=" + getCurrentChannel() + "]";
    }
}