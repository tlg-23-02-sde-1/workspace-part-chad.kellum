/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

    public static void main(String[] args) {
        // TODO: create two instances of your thread subclass and start them up
        MessagePrinter printer1 = new MessagePrinter("You say hello", 5, 2000);
        Thread thread1 = new Thread(printer1);
        thread1.start();

        MessagePrinter printer2 = new MessagePrinter("And I say goodbye!", 5, 3000);
        Thread thread2 = new Thread(printer2);
        thread2.start();


        MessagePrinter printer3 = new MessagePrinter("Hello, Hello", 10, 1000);
        Thread thread3 = new Thread(printer3);
        thread3.start();

        MessagePrinter printer4 = new MessagePrinter("I don't know why you say, \"Goodbye\", I say, \"Hello, hello, hello\"", 4, 3000);
        Thread thread4 = new Thread(printer4);
        thread4.start();
    }
}