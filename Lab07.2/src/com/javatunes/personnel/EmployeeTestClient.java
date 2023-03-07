package com.javatunes.personnel;

import com.fastjava.annotation.Fast;

class EmployeeTestClient {

    public static void main(String[] args) {
        Employee emp1 = new Employee();

        long begin = System.nanoTime();
        emp1.work();
        emp1.pay();
        double elapsedMillis = (end - begin) / 1_000_000.0;
        System.out.println("Elapsed time (ms): " + elapsedMillis);
    }

}