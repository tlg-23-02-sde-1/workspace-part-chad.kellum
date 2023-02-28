package com.entertainment.client;

import com.entertainment.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {


    public static void main(String[] args) {

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Samsung", 47);
        Television tvD = new Television("LG", 52);

        System.out.println("tvA == tvB: " + (tvA == tvB)); // always false
        System.out.println("tvA.equals(tvB)" + tvA.equals(tvB)); // true now that we added custom equals method

//        System.out.println(tvA.hashCode());
//        System.out.println(tvB.hashCode());
        System.out.println();

        // Let's create a Set<Television> and see what happens
        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);

        System.out.println("The size of the set is: " + tvs.size());
        for (Television tv : tvs) {
            System.out.println(tv);
        }

    }

}